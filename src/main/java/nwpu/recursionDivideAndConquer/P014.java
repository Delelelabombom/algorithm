package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P014 {

    static List<Integer>[] match;
    static boolean[] vis;
    static int num;

    public static int countArrangement(int n) {
        vis = new boolean[n + 1];
        match = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return num;
    }

    public static void backtrack(int index, int n) {
        if (index == n + 1) {
            num++;
            return;
        }
        for (Integer integer : match[index]) {
            if (!vis[integer]) {
                vis[integer] = true;
                backtrack(index + 1, n);
                vis[integer] = false;
            }
        }

    }


    public static void main(String[] args) {
        try {
            int n = Reader.nextInt();
            System.out.println(countArrangement(n));

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



