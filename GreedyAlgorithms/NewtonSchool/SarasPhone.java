package GreedyAlgorithms.NewtonSchool;

public class SarasPhone {
    static int Phone(int N, int K, int M){
        //Enter your code here
        if(N * K < M) {
            return -1;
        }

        int numberOfApps = M / K;

        if(M % K != 0) {
            numberOfApps++;
        }

        return numberOfApps;
    }
}
