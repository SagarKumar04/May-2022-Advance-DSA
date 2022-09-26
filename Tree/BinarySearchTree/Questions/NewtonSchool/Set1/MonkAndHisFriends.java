package Tree.BinarySearchTree.Questions.NewtonSchool.Set1;

import java.util.HashSet;
import java.util.Scanner;

public class MonkAndHisFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i = 0; i < N; i++) {
            int candies = scanner.nextInt();
            hashSet.add(candies);
        }

        for(int i = 0; i < M; i++) {
            int candies = scanner.nextInt();

            if(hashSet.contains(candies)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
                hashSet.add(candies);
            }
        }
    }
}
