package nwpu.recursionDivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 *
 * https://leetcode-cn.com/problems/super-pow/
 *
 */
public class P032 {

    static int base = 1337;

    public static final int myPower(int a, int k) {
        a %= base;
        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= a;
            result %= base;
        }
        return result;
    }

    public static final int superPow(int a, ArrayList<Integer> b) {
        if (b.isEmpty()) {
            return 1;
        }
        int last = b.get(b.size() - 1);
        b.remove(b.size() - 1);

        int part1 = myPower(a, last);
        int part2 = myPower(superPow(a, b), 10);
        return (part1 * part2) % base;

    }




    public static void main(String[] args) {
        try {
            String s = Reader.nextLine();
            int a = Integer.parseInt(s);
            String string = Reader.nextLine();
            string = string.substring(1, string.length() - 1);
            String[] strings = string.split(",");

            ArrayList<Integer> b = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {
                b.add(Integer.parseInt(strings[i]));
            }

            System.out.println(superPow(a, b));


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


