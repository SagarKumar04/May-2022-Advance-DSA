package GreedyAlgorithms.NewtonSchool;

import java.util.Scanner;

public class Rook {
    private int getNumberOfSteps(int X, int Y) {
        if(X == 1 && Y == 1) {
            return 0;
        }
        if(X == 1 || Y == 1) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        Rook rook = new Rook();
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int numberOfSteps = rook.getNumberOfSteps(X, Y);

        System.out.println(numberOfSteps);
    }
}
