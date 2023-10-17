package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 7};

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
