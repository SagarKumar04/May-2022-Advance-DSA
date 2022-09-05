package Tree.BinaryTree.Questions.NewtonSchool;

import java.util.Scanner;

public class CountLeavesInBinaryTree {
    public static void main (String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int count = 0;
        for(int i = 0; i < N; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            if(left + right  == -2) {
                count++;
            }
        }

        System.out.println(count);
    }
}
