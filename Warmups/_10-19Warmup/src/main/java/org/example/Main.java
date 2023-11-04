package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            arrayList.add(i);
        }

        for (int num : arrayList) {
            System.out.println(num);
        }

        int sum = 0;
        for (int num : arrayList) {
            sum += num;
        }
        System.out.println("Sum of all integers: " + sum);

        double average = sum / arrayList.size();
        System.out.println("Average of all integers: " + average);
    }
}
