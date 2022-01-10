package nwpu.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P047 {


    static int N = 210;
    static int[][] cache = new int[N][N];
    static public int getMoneyAmount(int n) {
        return dfs(1, n);
    }
    static int dfs(int l, int r) {
        if (l >= r) return 0;
        if (cache[l][r] != 0) return cache[l][r];
        int ans = 0x3f3f3f3f;
        for (int x = l; x <= r; x++) {
            // 当选择的数位 x 时，至少需要 cur 才能猜中数字
            int cur = Math.max(dfs(l, x - 1), dfs(x + 1, r)) + x;
            // 在所有我们可以决策的数值之间取最优
            ans = Math.min(ans, cur);
        }
        cache[l][r] = ans;
        return ans;
    }



    public static void main(String[] args) {
        try {
            int m = Reader.nextInt();
            System.out.println(getMoneyAmount(m));

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



