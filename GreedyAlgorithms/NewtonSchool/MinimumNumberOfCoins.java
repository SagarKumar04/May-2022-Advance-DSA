package GreedyAlgorithms.NewtonSchool;

import java.util.Scanner;

public class MinimumNumberOfCoins {
    private int minimumCoins(int Target){
        //Enter your code here
        int denominations[] = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        int numberOfNotes = 0;

        for(int i = 0; i < denominations.length; i++) {
            int currentDenominationCount = Target / denominations[i];
            numberOfNotes += currentDenominationCount;

            Target = Target % denominations[i];
            //Target = Target - (denominations[i] * currentDenominationCount);
        }

        return numberOfNotes;
    }

    public static void main(String[] args) {
        MinimumNumberOfCoins minimumNumberOfCoins = new MinimumNumberOfCoins();
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int i = 0; i < T; i++) {
            int target = scanner.nextInt();
            int numberOfCoins = minimumNumberOfCoins.minimumCoins(target);
            System.out.println(numberOfCoins);
        }
    }
}
