package GreedyAlgorithms.NewtonSchool;

import java.util.Scanner;

public class PoliceOfficerVicinity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxNorth = scanner.nextInt();
        int maxEast = scanner.nextInt();

        int policeX = scanner.nextInt();
        int policeY = scanner.nextInt();

        int numberOfBarriers = scanner.nextInt();

        int up = maxNorth;
        int down = 1;
        int left = 1;
        int right = maxEast;

        for(int i = 0; i < numberOfBarriers; i++) {
            int barrierX = scanner.nextInt();
            int barrierY = scanner.nextInt();

            if(barrierX == policeX) {
                //barrier behind the police
                if(barrierY < policeY) {
                    down = barrierY + 1;
                }
                //barrier in-front of the police
                else {
                    up = barrierY - 1;
                }
            }
            else if(barrierY == policeY) {
                //barrier is on the left side of the police
                if(barrierX < policeX) {
                    left = barrierX + 1;
                }
                //barrier is on the right side of the police
                else {
                    right = barrierX - 1;
                }
            }
        }

        int answer = (up - down) + (right - left);

        System.out.println(answer);
    }
}
