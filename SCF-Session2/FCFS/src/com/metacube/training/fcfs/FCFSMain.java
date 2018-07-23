package com.metacube.training.fcfs;

public class FCFSMain {

	public static void main(String[] args) {
		Schedular obj = new Schedular();
		System.out.println("average waiting time:" + obj.averageWaitingTime());
		System.out.println("maximum waiting time:" + obj.maximumWaitingTime());

	}

}
