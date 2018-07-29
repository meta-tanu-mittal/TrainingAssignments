package com.metacube.training.fcfs;

import java.util.Scanner;

/**
 * In FCFS find 1 completion time 2 waiting time 3 turn around time 4 average
 * waiting time 5 maximum waiting time
 * 
 * @author Tanu Mittal
 *
 */
public class Schedular {
	private int jobArray[][];
	private int n = 0;
	private int[] complete;
	private int[] wait;
	private int[] turnAround;
	Scanner sc = new Scanner(System.in);

	/**
	 * constructor of class
	 * 
	 * @param jobArray
	 *            is a 2D array of arrival time and burst time
	 */
	public Schedular(int[][] jobArray) {
		n = jobArray.length;
		this.jobArray = new int[n][2];
		this.jobArray = jobArray;
		complete = new int[n];
		wait = new int[n];
		turnAround = new int[n];
		sort();
		completionTime();
		waitingTime();
		turnAroundTime();
		display();
	}

	/**
	 * find completion time of all processes
	 * 
	 * @return array of completion time
	 */
	public int[] completionTime() {
		for (int i = 0; i < n; i++) {
			if (i == 0 || jobArray[i][0] > complete[i - 1]) {
				complete[i] = jobArray[i][0] + jobArray[i][1];
				continue;
			} else {
				complete[i] = complete[i - 1] + jobArray[i][1];

			}
		}
		return complete;

	}

	/**
	 * find turn around time of all jobs
	 * 
	 * @return array of turn around time
	 */
	public int[] turnAroundTime() {
		for (int i = 0; i < n; i++) {
			turnAround[i] = complete[i] - jobArray[i][0];
		}
		return turnAround;

	}

	/**
	 * find waiting time of all jobs
	 * 
	 * @return array of waiting time
	 */
	public int[] waitingTime() {
		for (int i = 0; i < n; i++) {
			if (i == 0 || jobArray[i][0] > complete[i - 1]) {
				wait[i] = 0;
			} else {
				wait[i] = complete[i - 1] - jobArray[i][0];

			}
		}
		return wait;

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
