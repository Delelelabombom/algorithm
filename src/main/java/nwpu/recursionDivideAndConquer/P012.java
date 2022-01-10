package nwpu.recursionDivideAndConquer;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences/solution/lian-xu-chai-xiang-tong-de-shu-zi-by-leetcode-2/
 */
public class P012 {

    public static ArrayList<Integer> numsSameConsecDiff(int N, int K) {
        Set<Integer> cur = new HashSet();
        for (int i = 1; i <= 9; ++i)
            cur.add(i);

        for (int steps = 1; steps <= N-1; ++steps) {
            Set<Integer> cur2 = new HashSet();
            for (int x: cur) {
                int d = x % 10;
                if (d-K >= 0)
                    cur2.add(10*x + (d-K));
                if (d+K <= 9)
                    cur2.add(10*x + (d+K));
            }

            cur = cur2;
        }

        if (N == 1)
            cur.add(0);

        ArrayList<Integer> list = new ArrayList<>();

        for (int x: cur)
            list.add(x);
        return list;
    }


    public static void main(String[] args) {
        try {
            int n = Reader.nextInt();
            int k = Reader.nextInt();
            ArrayList<Integer> list = numsSameConsecDiff(n, k);
            list.sort(Comparator.naturalOrder());
            //System.out.println(list);
            String s = list.toString();
            s = s.replace(" ", "");
            System.out.println(s);


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



