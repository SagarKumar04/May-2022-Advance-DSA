package Tree.BinaryTree.Questions.NewtonSchool.Set1;

import java.util.Scanner;

public class ReRooting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for(int i = 1; i <= N; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            if(left == -1 || right == -1) {
                System.out.print(i + " ");
            }
        }
    }
}
