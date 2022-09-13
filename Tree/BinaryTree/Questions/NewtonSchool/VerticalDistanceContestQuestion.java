package Tree.BinaryTree.Questions.NewtonSchool;

import java.util.Scanner;

public class VerticalDistanceContestQuestion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int Q = scanner.nextInt();

        int verticalDistance[] = new int[N + 1];
        verticalDistance[1] = 0;

        for(int i = 1; i <= N; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            if(left != -1) {
                verticalDistance[left] = verticalDistance[i] - 1;
            }

            if(right != -1) {
                verticalDistance[right] = verticalDistance[i] + 1;
            }
        }

        for(int i = 1; i <= Q; i++) {
            int query = scanner.nextInt();

            System.out.println(verticalDistance[query]);
        }
    }
}
