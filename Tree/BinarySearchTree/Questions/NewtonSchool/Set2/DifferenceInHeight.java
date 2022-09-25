package Tree.BinarySearchTree.Questions.NewtonSchool.Set2;

import java.util.Scanner;

public class DifferenceInHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //int answer = ((int)Math.pow(2, n) - 1) - n;
        int answer = (1 << n) - 1 - n;

        System.out.println(answer);
    }
}
