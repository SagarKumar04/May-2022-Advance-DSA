package GreedyAlgorithms.NewtonSchool;

public class MinimumCoins {
    static int minimumCoins(int Target){
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
}
