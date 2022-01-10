package nwpu.recursionDivideAndConquer;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 */
public class P034 {

    public static final int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Character c : counter.keySet()) {
            if (counter.get(c) < k) {
                int result = 0;
                for (String s1 : s.split(String.valueOf(c))) {
                    result = Math.max(result, longestSubstring(s1, k));
                }
                return result;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            int k = Reader.nextInt();
            string = string.substring(1, string.length() - 1);
            System.out.println(longestSubstring(string, k));


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