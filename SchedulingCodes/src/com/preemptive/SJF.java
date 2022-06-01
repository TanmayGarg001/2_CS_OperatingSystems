package com.preemptive;

import java.util.Arrays;
import java.util.Scanner;

public class SJF {

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
        int[] arrArr = new int[n];
        for (int i = 0; i < burstArr.length; i++) {
            System.out.print("Enter the arrival time of process " + (i + 1) + " : ");
            arrArr[i] = scanner.nextInt();
        }
        System.out.println("Arrival time array: " + Arrays.toString(arrArr));

    }

}
