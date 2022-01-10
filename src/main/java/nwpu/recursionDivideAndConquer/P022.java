package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * https://leetcode-cn.com/problems/predict-the-winner/
 *
 * https://leetcode-cn.com/problems/predict-the-winner/solution/486-yu-ce-ying-jia-san-chong-di-gui-dong-tai-gui-h/
 *
 *
 */
public class P022 {

    public static int getScore(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int selectLeft = 0, selectRight = 0;
        if ((end - start) >= 2) {
            selectLeft = nums[start] + Math.min(getScore(nums, start + 2, end), getScore(nums, start + 1, end - 1));
            selectRight = nums[end] + Math.min(getScore(nums, start, end - 2), getScore(nums, start + 1, end - 1));

        }

        if ((end - start) == 1) {
            selectLeft = nums[start];
            selectRight = nums[end];
        }

        return Math.max(selectLeft, selectRight);

    }

    public static int predictTheWinner(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int player1 = getScore(nums, 0, nums.length - 1);
        int player2 = sum - player1;
        return (player1 >= player2) ? 1 : 0;

    }



    public static void main(String[] args) {
        try {
            String string =Reader.nextLine();
            String[] strings = string.split(",");
            int[] list = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                list[i] = Integer.parseInt(strings[i]);
            }
            System.out.println(predictTheWinner(list));

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

