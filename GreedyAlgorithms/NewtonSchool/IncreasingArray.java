package GreedyAlgorithms.NewtonSchool;

import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int arr[] = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        boolean isPossible = true;
        int divisor = 2;
        for(int i = 1; i < N; i++) {
            while((divisor <= arr[i]) && arr[i] % divisor != 0) {
                divisor++;
            }

            if(divisor > arr[i]) {
                isPossible = false;
                break;
            }

            divisor++;
        }

        if(isPossible) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
