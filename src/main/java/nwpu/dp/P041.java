package nwpu.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P041 {

    public static final int solution(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        if (nums.length > 2) {
            dp[0] = nums[0];
            dp[1] = nums[1];
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.min(dp[i-1] + nums[i - 1], dp[i-2] + nums[i-2]);
            }
        }


        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            String[] strings = string.split(" ");
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



