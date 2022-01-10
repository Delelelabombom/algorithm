package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * https://leetcode-cn.com/problems/jump-game-iii/solution/tiao-yue-you-xi-iii-by-leetcode-solution/
 *
 *
 */
public class P017 {

    public static final boolean canReach(int[] nums, int start) {
        boolean[] visited = new boolean[nums.length];
        return assist(visited,nums,start);
    }

    public static final boolean assist(boolean[] visited, int[] nums, int start) {
        if (start>= nums.length || start<0) {
            return false;
        }
        if (nums[start] == 0) {
            return true;
        }

        if (visited[start]) {
            return false;
        }
        visited[start] = true;
        return assist(visited, nums, start+nums[start]) || assist(visited, nums, start-nums[start]);
    }


    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            int start = Reader.nextInt();
            string = string.substring(1, string.length() - 1);
            String[] strings = string.split(",");
            int[] list = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                list[i] = Integer.parseInt(strings[i]);
            }
            System.out.println(canReach(list, start));

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



