package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class ViewParser {

    public static String read() throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your word");
        System.out.println("Recommend: love");
        String string = stdin.readLine();
        return string;
    }

    public static void massage(String massage) {
        System.out.println(massage);
    }
}
