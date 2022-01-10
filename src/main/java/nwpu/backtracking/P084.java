package nwpu.backtracking;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class P084 {
    static List<List<Character>> result = new ArrayList<>();
    static List<Character> path = new ArrayList<>();

    static void backTrack(char[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }

            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }

        }

    }



    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            char[] list = string.toCharArray();
            boolean[] used = new boolean[list.length];
            Arrays.sort(list);
            backTrack(list, used);
            for (List<Character> characters : result) {
                for (Character character : characters) {
                    System.out.print(character);
                }
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



