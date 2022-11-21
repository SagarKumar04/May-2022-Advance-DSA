package BitManipulation;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int num1 = 54;
        int num2 = 31;

        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;

        System.out.println(num1 + " " + num2);
    }
}
