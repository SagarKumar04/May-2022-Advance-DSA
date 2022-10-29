package DynamicProgramming;

public class ZeroOneKnapsack {
    private int zeroOneKnapsack(int n, int weight[], int values[], int W) {
        int knapsackMatrix[][] = new int[n + 1][W + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= W; j++) { //j - current knapsack capacity
                //if the number of items taken is 0, or the knapsack capacity is 0
                if(i == 0 || j == 0) {
                    knapsackMatrix[i][j] = 0;
                }
                //if the current item being considered can fit into the knapsack
                else if(weight[i - 1] <= j) {
                    //two options - take the item or leave the item

                    //take the item
                    int accepted = values[i - 1] + knapsackMatrix[i - 1][j - weight[i - 1]];

                    //leave the item
                    int rejected = knapsackMatrix[i - 1][j];

                    knapsackMatrix[i][j] = Math.max(accepted, rejected);
                }
                //if the current item being considered cannot fit into the knapsack
                else {
                    knapsackMatrix[i][j] = knapsackMatrix[i - 1][j];
                }
            }
        }

        System.out.println("Knapsack Matrix: ");
        for(int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                //System.out.print(knapsackMatrix[i][j] + " ");
                System.out.printf("%3d", knapsackMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        return knapsackMatrix[n][W];
    }

    public static void main(String[] args) {
        int n = 3;
        int weight[] = {1, 2, 3};
        int values[] = {10, 15, 40};
        int W = 6;

        ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
        int result = zeroOneKnapsack.zeroOneKnapsack(n ,weight, values, W);

        System.out.println("Result: " + result);
    }
}
