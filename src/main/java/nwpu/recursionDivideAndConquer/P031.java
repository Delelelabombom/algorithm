package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P031 {


    public static void main(String[] args) {
        try {
            Stack<Integer> stack = new Stack<>();
            int n = Reader.nextInt();
            int m = Reader.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i < n; i++) {
                a[i] = i + 1;
            }
            a[n]=1;
            int p = 0;
            int j = n;
            int k = 1;
            while (p<n) {
                while (k<m){
                    j = a[j];
                    k++;
                }
                //
                stack.push(a[j]);
                p++;
                a[j]=a[a[j]];
                k=1;
            }
            System.out.println(stack.peek() - 1);

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



