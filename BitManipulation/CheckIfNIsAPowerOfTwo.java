package BitManipulation;

public class CheckIfNIsAPowerOfTwo {
    private void checkIfNIsAPowerOfTwo(int n) {
        int result = n & (n - 1);

        if(result == 0) {
            System.out.println(n + " is a power of 2");
        }
        else {
            System.out.println(n + " is not a power of 2");
        }
    }

    public static void main(String[] args) {
        CheckIfNIsAPowerOfTwo checkIfNIsAPowerOfTwo
                = new CheckIfNIsAPowerOfTwo();

        int notAPowerOf2 = 88;
        int powerOf2 = 128;

        checkIfNIsAPowerOfTwo.checkIfNIsAPowerOfTwo(notAPowerOf2);
        checkIfNIsAPowerOfTwo.checkIfNIsAPowerOfTwo(powerOf2);
    }
}
