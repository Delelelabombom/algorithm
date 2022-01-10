package nwpu.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2chinahttps://leetcode-cn.com/problems/partition-equal-subset-sum/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 *
 *
 */
public class P093 {
    static boolean solution(int[] list) {
        int len = list.length;
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        if (list[0] <= target) {
            dp[0][list[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target ; j++) {
                dp[i][j] = dp[i - 1][j];

                if (list[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (list[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - list[i]];
                }
            }
        }

        return dp[len - 1][target];
    }


    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            String[] strings = string.split(",");
            int[] list = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                list[i] = Integer.parseInt(strings[i]);
            }
            System.out.println(solution(list));

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



