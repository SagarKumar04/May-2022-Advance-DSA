package GreedyAlgorithms.NewtonSchool;

public class DragonSlayer {
    static int DragonSlayer(int A, int B, int C,int D) {
        //Enter your code here
        int dragonHealth = A;
        int dragonAttackPower = B;
        int natsuHealth = C;
        int natsuAttackPower = D;

        int dragonAttackCount = dragonHealth / natsuAttackPower;
        if(dragonHealth % natsuAttackPower != 0) {
            dragonAttackCount++;
        }

        int natsuAttackCount = natsuHealth / dragonAttackPower;
        if(natsuHealth % dragonAttackPower != 0) {
            natsuAttackCount++;
        }

        if(natsuAttackCount >= dragonAttackCount) {
            return 1;
        }

        return 0;
    }
}
