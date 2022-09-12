import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {
        //using Scanner
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();


        //using BufferedReader
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        String iStr = bufferedReader.readLine();
        int iInt = Integer.parseInt(iStr);

        /*
        The above two lines can be written in one as:
        int iInt = Integer.parseInt(bufferedReader.readLine());
         */
    }
}
