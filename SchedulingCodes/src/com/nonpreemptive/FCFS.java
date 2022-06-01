package com.nonpreemptive;

import java.util.Arrays;
import java.util.Scanner;

public class FCFS {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the amount of processes: ");
        int n = scanner.nextInt();
        int[] burstArr = new int[n];
        for (int i = 0; i < burstArr.length; i++) {
            System.out.print("Enter the burst time of process " + (i + 1) + " : ");
            burstArr[i] = scanner.nextInt();
        }
        System.out.println("CPU Burst array: " + Arrays.toString(burstArr));

        int[] compArr = new int[n];
        int sum = 0;
        double avgComp = 0;
        for (int i = 0; i < compArr.length; i++) {
            sum = sum + burstArr[i];
            compArr[i] = sum;
            avgComp = avgComp + compArr[i];
        }
        System.out.println("Completion/Turn-Around time array: " + Arrays.toString(compArr));
        System.out.println("Completion/Turn-Around time average: " + avgComp / n);

        int[] wtArr = new int[n];
        double avgWt = 0;
        for (int i = 0; i < wtArr.length; i++) {
            wtArr[i] = compArr[i] - burstArr[i];
            avgWt = avgWt + wtArr[i];
        }
        System.out.println("Waiting time array: " + Arrays.toString(wtArr));
        System.out.println("Waiting time average: " + avgWt / n);

    }

}
