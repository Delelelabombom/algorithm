package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://leetcode-cn.com/problems/burst-balloons/
 *
 * https://leetcode-cn.com/problems/burst-balloons/solution/zhe-ge-cai-pu-zi-ji-zai-jia-ye-neng-zuo-guan-jian-/
 *
 *
 */
public class P015 {

    public static final int maxCoin(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n+2];
        temp[0] = 1;
        temp[n+1] = 1;
        for (int i = 0; i < n; i++) {
            temp[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];

        for (int len = 3; len <= n+2 ; len++) {
            for (int i = 0; i <= n+2-len; i++) {
                int res = 0;
                for (int k = i+1; k < i+len-1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i+len-1];
                    res = Math.max(res, left+right+temp[i]*temp[k]*temp[i+len-1]);
                }
                dp[i][i+len-1] = res;
            }
        }
        return dp[0][n+1];
    }


    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            string = string.substring(1, string.length() - 1);
            String[] strings = string.split(",");
            int[] list = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                list[i] = Integer.parseInt(strings[i]);
            }
            System.out.println(maxCoin(list));


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



