package BitManipulation;

public class CountNumberOfSetBits {
    public static void main(String[] args) {
        int n = 55;

        int count = 0;
        while(n > 0) {
            int result = n & 1;

            if(result != 0) {
                count++;
            }

            n = (n >> 1);
        }

        System.out.println(count);
    }
}
