package Tree.BinarySearchTree.Questions.NewtonSchool.Set3;

import java.util.Scanner;

public class UniqueBSTCombinationFormula {
    private int nCr(int n, int r) {
        if((n - r) < r) {
            r = n - r;
        }

        int ncr = 1;

        for(int i = 0; i < r; i++) {
            ncr *= (n - i);
            ncr /= (i + 1);
        }

        return ncr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UniqueBSTCombinationFormula uniqueBSTCombinationFormula
                = new UniqueBSTCombinationFormula();

        int N = scanner.nextInt();

        int numerator = uniqueBSTCombinationFormula.nCr(2 * N, N);
        int denominator = (N + 1);

        int answer = numerator / denominator;

        System.out.println(answer);
    }
}
