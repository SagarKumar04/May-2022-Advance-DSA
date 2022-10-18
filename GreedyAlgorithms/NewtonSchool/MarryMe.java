package GreedyAlgorithms.NewtonSchool;

import java.util.Scanner;

public class MarryMe {
    private boolean isGettingMarried(String R, String G) {
        int lengthR = R.length();
        int lengthG = G.length();

        String smallerString;
        String largerString;

        if(lengthG < lengthR) {
            smallerString = G;
            largerString = R;
        }
        else {
            smallerString = R;
            largerString = G;
        }

        int i = 0;
        int j = 0;

        while(i < smallerString.length() && j < largerString.length()) {
            if(smallerString.charAt(i) == largerString.charAt(j)) {
                i++;
            }
            j++;
        }

        if(i == smallerString.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MarryMe marryMe = new MarryMe();

        int T = scanner.nextInt();
        scanner.nextLine();
        for(int i = 1; i <= T; i++) {
            String R = scanner.next();
            String G = scanner.next();

            boolean isGettingMarried = marryMe.isGettingMarried(R, G);

            if(isGettingMarried) {
                System.out.println("#SadLife");
            }
            else {
                System.out.println("#DieSingle");
            }
        }
    }
}
