package com.preemptive;

import java.util.Arrays;
import java.util.Scanner;

public class RR {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the time quantum: ");
        int tq = scanner.nextInt();
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        int[] burstArr = new int[n];
        for (int i = 0; i < burstArr.length; i++) {
            System.out.print("Enter the burst time for process " + (i + 1) + " : ");
            burstArr[i] = scanner.nextInt();
        }
        int[] burstArr2 = new int[n];
        for (int i = 0; i < n; i++) {
            burstArr2[i] = burstArr[i];
        }
        System.out.println("CPU Burst array: " + Arrays.toString(burstArr));
        if (tq <= 0) {
            System.out.println("HALTED!");
        }

        int[] compArr = new int[n];
        int count = 0;
        int i = 0;
        while (true) {
            if (i == n) {
                i = 0;
            }
            if (burstArr[i] > 0) {
                if (burstArr[i] > tq) {
                    burstArr[i] = burstArr[i] - tq;
                    compArr[i] = compArr[i] + tq;
                    for (int x = 0; x < n; x++) {
                        if (burstArr[x] > 0 && x != i) {
                            compArr[x] = compArr[x] + tq;
                        }
                    }
                } else {
                    for (int x = 0; x < n; x++) {
                        if (burstArr[x] > 0) {
                            compArr[x] = compArr[x] + burstArr[i];
                        }
                    }
                    burstArr[i] = -1;
                    count++;
                }
            }
            i++;
            if (count == n) {
                break;
            }
        }
        int[] wtArr = new int[n];
        double avgWt = 0;
        for (int a = 0; a < n; a++) {
            wtArr[a] = compArr[a] - burstArr2[a];
            avgWt = avgWt + wtArr[a];
        }
        double avgCom = 0;
        for (int i1 = 0; i1 < n; i1++) {
            avgCom = avgCom + compArr[i1];
        }
        System.out.println("===========");
        System.out.println("Completion/Turn Around Time Array: " + Arrays.toString(compArr));
        System.out.println("Completion/Turn Around average: " + avgCom / n);
        System.out.println("Waiting Time Array: " + Arrays.toString(wtArr));
        System.out.println("Waiting Time average: " + avgWt / n);

    }

}
