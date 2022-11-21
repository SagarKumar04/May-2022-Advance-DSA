package BitManipulation;

public class CheckIfKthBitIsSetOrNot {
    //considering 0-based value of 'k'
    private void checkUsingLeftShift(int n, int k) {
        int result = (n & (1 << k));

        if(result > 0) {
            System.out.println("Set");
        }
        else {
            System.out.println("Not set");
        }
    }

    private void checkUsingRightShift(int n, int k) {
        int result = ((n >> k) & 1);

        if(result > 0) {
            System.out.println("Set");
        }
        else {
            System.out.println("Not set");
        }
    }

    public static void main(String[] args) {
        CheckIfKthBitIsSetOrNot checkIfKthBitIsSetOrNot
                = new CheckIfKthBitIsSetOrNot();

        int n = 74;
        int k = 3;
        checkIfKthBitIsSetOrNot.checkUsingLeftShift(n, k);

        checkIfKthBitIsSetOrNot.checkUsingRightShift(n, k);
    }
}
