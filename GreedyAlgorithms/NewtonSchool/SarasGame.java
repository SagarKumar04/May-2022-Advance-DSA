package GreedyAlgorithms.NewtonSchool;

public class SarasGame {
    static int minDistanceCoveredBySara_AnujSolution(int N) {
        int n = 0;
        n = (N * (N + 1)) / 2;
        if(n % 2 == 1) {
            return 1;
        }
        else {
            return 0;
        }

        /*
        The above if-else block can be reduced to the below:
        return (n % 2);
         */
    }
    static int minDistanceCoveredBySara_AnandSolution(int N){
        //Anand's solution
        if((N % 4 == 0) || (N + 1 % 4 == 0)) {
            return 0;
        }
        return 1;
    }
}
