package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P013 {

    public static boolean fun(int n, int k) {
        if (n == 1 && k == 1) {
            return false;
        }
        if (n == 2) {
            if (k == 1) {
                return false;
            }else {
                return true;
            }
        }


        if (k <= (1 << (n - 2))) {
            return fun(n - 1, k);
        }else {
            return !fun(n - 1, k - (1 << (n - 2)));
        }
    }


    public static void main(String[] args) {
        try {
            int n = Reader.nextInt();
            int i = Reader.nextInt();
            boolean b = fun(n, i);
            if (b) {
                System.out.println(1);
            } else {
                System.out.println(0);
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



