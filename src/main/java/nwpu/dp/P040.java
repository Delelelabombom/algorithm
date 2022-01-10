package nwpu.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/solution/gong-shui-san-xie-xiang-jie-xian-xing-dp-m9q9/
 *
 *
 */
public class P040 {

    static int mod = (int)1e9+7;
    static public int numWays(int steps, int len) {
        int max = Math.min(steps / 2, len - 1);
        int[][] f = new int[steps + 1][max + 1];
        f[steps][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            for (int j = 0; j <= max; j++) {
                f[i][j] = (f[i][j] + f[i + 1][j]) % mod;
                if (j - 1 >= 0) f[i][j] = (f[i][j] + f[i + 1][j - 1]) % mod;
                if (j + 1 <= max) f[i][j] = (f[i][j] + f[i + 1][j + 1]) % mod;
            }
        }
        return f[0][0];
    }

    public static void main(String[] args) {
        try {
            int steps = Reader.nextInt();
            int n = Reader.nextInt();
            System.out.println(numWays(steps, n));


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



