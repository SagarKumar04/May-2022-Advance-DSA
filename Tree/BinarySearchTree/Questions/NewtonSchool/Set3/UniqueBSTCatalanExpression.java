package Tree.BinarySearchTree.Questions.NewtonSchool.Set3;

import java.util.Scanner;

public class UniqueBSTCatalanExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int catalan[] = new int[N + 1];

        catalan[0] = catalan[1] = 1;

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < i; j++) {
                catalan[i] += (catalan[j] * catalan[i - 1 - j]);
            }
        }

        System.out.println(catalan[N]);
    }
}
