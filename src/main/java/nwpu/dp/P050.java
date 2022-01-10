package nwpu.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P050 {

    public static int findIntegers(int n) {
        return 1 + dfs(1, n);  //0也是符合条件的，要加上1
    }
    public static int dfs(int i, int n) {
        return i > n ? 0 : 1 + dfs(i << 1, n) + ((i & 1) == 1 ? 0 : dfs((i << 1) + 1, n));
    }

    public static void main(String[] args) {
        try {

            int i  = Reader.nextInt();
            System.out.println(findIntegers(i));

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



