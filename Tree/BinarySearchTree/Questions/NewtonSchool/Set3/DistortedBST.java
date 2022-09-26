package Tree.BinarySearchTree.Questions.NewtonSchool.Set3;

import java.util.Arrays;
import java.util.Scanner;

public class DistortedBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int input[] = new int[N];
        int sorted[] = new int[N];
        for(int i = 0; i < N; i++) {
            input[i] = scanner.nextInt();
            sorted[i] = input[i];
        }

        Arrays.sort(sorted);

        int sum = 0;

        for(int i = 0; i < N; i++) {
            if(input[i] != sorted[i]) {
                sum += (input[i] + sorted[i]);
                break;
            }
        }

        System.out.println(sum);
    }
}
