package com.metacube.training.fcfs;

import java.util.Scanner;

public class Schedular {
	private int jobArray[][] = new int[10][2];
	private int n = 0;
	private int[] complete = new int[10];
	private int[] wait = new int[10];
	private int[] turnAround = new int[10];
	Scanner sc = new Scanner(System.in);

	/**
	 * constructor of a class used to initialize variables
	 */
	public Schedular() {
		System.out.println("enter no of process less than 10");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("enter arrival time and burst time p[" + (i + 1) + "]:");
			jobArray[i][0] = sc.nextInt();
			jobArray[i][1] = sc.nextInt();
		}
		sort();
		completionTime();
		waitingTime();
		turnAroundTime();
		display();
	}

	/**
	 * find the completion time of all jobs
	 */
	public void completionTime() {
		for (int i = 0; i < n; i++) {
			if (i == 0 || jobArray[i][0] > complete[i - 1]) {
				complete[i] = jobArray[i][0] + jobArray[i][1];
				continue;
			} else {
				complete[i] = complete[i - 1] + jobArray[i][1];

			}
		}

	}

	/**
	 * find turn around time of all jobs
	 */
	public void turnAroundTime() {
		for (int i = 0; i < n; i++) {
			turnAround[i] = complete[i] - jobArray[i][0];
		}

	}

	/**
	 * find waiting time of all jobs
	 */
	public void waitingTime() {
		for (int i = 0; i < n; i++) {
			if (i == 0 || jobArray[i][0] > complete[i - 1]) {
				wait[i] = 0;
			} else {
				wait[i] = complete[i - 1] - jobArray[i][0];

			}
		}

	}

	/**
	 * find average waiting time
	 * 
	 * @return average waiing time
	 */
	public double averageWaitingTime() {
		double avg = 0;
		for (int i = 0; i < n; i++) {
			avg += wait[i];
		}
		return (avg / n);
	}

	/**
	 * find maximum waiting time
	 * 
	 * @return maximum waiting time
	 */
	public int maximumWaitingTime() {
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (wait[i] > max) {
				max = wait[i];
			}
		}
		return max;
	}

	/**
	 * sort the jobs according to their arrival time
	 */
	public void sort() {

		for (int i = 0; i < (n - 1); i++) {
			for (int j = 0; j < (n - i - 1); j++) {
				if (jobArray[j][0] > jobArray[j + 1][0]) {
					int temp1, temp2;
					temp1 = jobArray[j][0];
					temp2 = jobArray[j][1];
					jobArray[j][0] = jobArray[j + 1][0];
					jobArray[j][1] = jobArray[j + 1][1];
					jobArray[j + 1][0] = temp1;
					jobArray[j + 1][1] = temp2;
				}
			}
		}
	}

	/**
	 * display all the time of jobs
	 */
	public void display() {
		System.out
				.println("process\t arrival time \t burst time \t waiting time \t completion time \t turn around time");
		for (int i = 0; i < n; i++) {
			System.out.println("p[" + (i + 1) + "]\t\t" + jobArray[i][0] + "\t\t" + jobArray[i][1] + "\t\t" + wait[i]
					+ "\t\t" + complete[i] + "\t\t" + turnAround[i]);
		}
	}
}
