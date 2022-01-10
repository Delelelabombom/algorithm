package nwpu.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 *
 *
 */
public class P036 {

    static int[] nums = new int[]{2, 3, 5};

    public static final int uglyNum(int n) {
        Set<Long> set = new HashSet<>();
        Queue<Long> queue = new PriorityQueue<>();
        set.add(1L);
        queue.add(1L);
        for (int i = 1; i <= n; i++) {
            long x = queue.poll();
            if (i == n) {
                return (int) x;
            }
            for (int num : nums) {
                long t = num * x;
                if (!set.contains(t)) {
                    set.add(t);
                    queue.add(t);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            int n = Reader.nextInt();
            System.out.println(uglyNum(n));


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



