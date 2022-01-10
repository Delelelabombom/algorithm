package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P026 {

    public static boolean solution(String string1, String string2) {
        boolean dp[][] = new boolean[1 + string1.length()][1 + string2.length()];
        dp[0][0] = true;
        dp[1][0] = true;

        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (string1.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (string1.charAt(i - 1) == string2.charAt(j - 1));
                }
            }
        }
        return dp[string1.length()][string2.length()];
    }


    public static void main(String[] args) {
        try {
            String string1 = Reader.nextLine();
            String string2 = Reader.nextLine();


            System.out.println(solution(string2, string1) ? 1 : 0);

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



