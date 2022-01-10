package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://blog.csdn.net/mcc6688/article/details/108546069
 *
 *https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/
 *
 *https://programmercarl.com/0070.%E7%88%AC%E6%A5%BC%E6%A2%AF.html#%E6%80%9D%E8%B7%AF
 *
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/jian-zhi-offer-10-ii-qing-wa-tiao-tai-ji-2f3a/
 */
public class P011 {


    public static void main(String[] args) {
        try {
            int n = Reader.nextInt();
            if (n >= 2) {
                long[] dp = new long[n + 1];
                dp[0] = 1;
                dp[1] = 1;
                for (int i = 2; i <= n; i++) {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % (1000000007) ;
                }
                System.out.print((long)(dp[n] % (1000000007)));

            }else if (n == 1) {
                System.out.print(1);
            }else {// n == 0
                System.out.print(1);
            }


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



