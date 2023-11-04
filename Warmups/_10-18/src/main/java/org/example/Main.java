package org.example;

public class Main {
    public static void main(String[] args) {
        int[] matchGoals = {2, 3, 1, 4, 2, 0, 2, 1, 3, 2};

        int totalGoals = 0;
        for (int goals : matchGoals) {
            totalGoals += goals;
        }
        double averageGoals =  totalGoals / matchGoals.length;

        System.out.println("Total number of goals: " + totalGoals);
        System.out.println("Average number of goals: " + averageGoals);
    }
}
