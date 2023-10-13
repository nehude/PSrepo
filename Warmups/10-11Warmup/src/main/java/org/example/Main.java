package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("Even numbers from 1 to 20:");
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i + " ");
        }

        System.out.println("Odd numbers from 1 to 19:");
        int j = 1;
        while (j <= 19) {
            System.out.println(j + " ");
            j += 2;
        }

        System.out.println("Numbers between 1 and 100 divisible by both 7 and 9:");
        for (int i = 1, num = 0; i <= 100 && num < 3; i++) {
            if (i % 7 == 0 && i % 9 == 0) {
                System.out.println(i);
                num++;
            }
        }
    }
}