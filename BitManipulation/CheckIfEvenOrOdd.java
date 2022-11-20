package BitManipulation;

public class CheckIfEvenOrOdd {
    public static void main(String[] args) {
        int n = 1961;

        if((n & 1) == 1) {
            System.out.println("Odd");
        }
        else {
            System.out.println("Even");
        }
    }
}
