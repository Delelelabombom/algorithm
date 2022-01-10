package nwpu.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P042 {

    public static final boolean solution(String str1, String str2) {
        int i = 0, j = 0;
        for (; j < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(j) == str2.charAt(i)) {
                j++;
            }
        }
        return j == str1.length();
    }

    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            String string2 = Reader.nextLine();
            System.out.println(solution(string, string2));


        }catch (IOException e) {

        }
    }

    class Reader {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");
        static String nextLine() throws IOException {
            return reader.readLine();
        }
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }
        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}



