package nwpu.backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 *https://leetcode-cn.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 *
 *
 */
public class P085 {

    static String solution(int n, int k) {
        int count = 3 << (n - 1);
        if (k > count) {
            return "";
        }
        char[] result = new char[n];
        int[][] stateTab = new int[][]{{1,2},{0,2},{0,1}};
        int order = k -1;
        int index = 0, state = order>>(n - 1);
        result[index++] = (char) (state + 'a');
        int tree= order % (1 << (n - 1));
        for (int i = n - 2; i >= 0 ; i--) {
            state = stateTab[state][(tree >> i) & 1];
            result[index++] = (char) (state + 'a');
        }
        return String.valueOf(result);
    }


    public static void main(String[] args) {
        try {
            int n =Reader.nextInt();
            int k =Reader.nextInt();
            System.out.println(solution(n, k));

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

