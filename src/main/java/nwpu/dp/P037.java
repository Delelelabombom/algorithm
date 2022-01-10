package nwpu.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * https://leetcode-cn.com/problems/matchsticks-to-square/
 */
public class P037 {

    public static final boolean makeSquare(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total == 0 || (total & 3) != 0) {
            return false;
        }
        return backtrack(nums, 0, total >> 2, new int[4]);

    }

    public static final boolean backtrack(int[] nums, int index, int target, int[] size) {
        if (index == nums.length) {
            if ((size[0] == size[1]) && (size[1] == size[2]) && (size[2] == size[3])) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < size.length; i++) {
            if (size[i] + nums[index] > target) {
                continue;
            }
            size[i] += nums[index];
            if (backtrack(nums, index + 1, target, size)) {
                return true;
            }
            size[i] -= nums[index];
        }

        return false;
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
            System.out.println(makeSquare(list));

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


