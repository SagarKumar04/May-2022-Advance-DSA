package GreedyAlgorithms.NewtonSchool;

public class King {
    static int King(int X, int Y) {
        //Enter your code here
        int directions[][] = {
                {0, -1},
                {0, 1},
                {-1, 0},
                {-1, -1},
                {-1, 1},
                {1, 0},
                {1, -1},
                {1, 1}
        };

        int positionCount = 0;

        for(int i = 0; i < directions.length; i++) {
            int nextX = X + directions[i][0];
            int nextY = Y + directions[i][1];

            if (nextX >= 1
                    && nextX <= 8
                    && nextY >= 1
                    && nextY <= 8) {
                positionCount++;
            }
        }

        return positionCount;
    }
}
