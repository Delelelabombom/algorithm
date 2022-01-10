package nwpu.recursionDivideAndConquer;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://leetcode-cn.com/problems/maximum-sum-circular-subarray/solution/zhua-zhong-dian-jian-ji-dai-ma-miao-dong-nec7/
 *
 * 最大的连续数字
 * Description
 *
 * 给定一个数组，找出该数组当中连续的且合最大的一组数字。首尾两个数字也是连续的。
 *
 *
 * Input
 * 输入数组中的各个位置上的数值，以,分隔开
 *
 *
 * Output
 * 输出合最大的组合的合
 *
 *
 * Sample Input 1
 *
 * -1,1,2,3,-2
 * Sample Output 1
 *
 * 6
 */
public class P023 {


    static  public int solution(int[] list) {
        int maxSum = list[0];
        int minSum = list[0];
        int[] dp = new int[list.length];
        int[] dpMin = new int[list.length];
        dp[0] = list[0];
        dpMin[0] = list[0];
        int sum = list[0];
        for (int i = 1; i < list.length; i++) {
            dp[i] = Math.max(list[i], dp[i - 1] + list[i]);
            maxSum = Math.max(maxSum, dp[i]);

            dpMin[i] = Math.min(list[i], dpMin[i - 1] + list[i]);
            minSum = Math.min(minSum, dpMin[i]);

            sum += list[i];
        }


        return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
    }


    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            if (!string.equals("")) {
                String[] strings = string.split(",");
                int[] list = new int[strings.length];
                for (int i = 0; i < strings.length; i++) {
                    list[i] = Integer.parseInt(strings[i]);
                }
                System.out.println(solution(list));
            } else {
                System.out.println();
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



