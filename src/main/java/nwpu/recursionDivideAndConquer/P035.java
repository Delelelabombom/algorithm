package nwpu.recursionDivideAndConquer;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *https://leetcode-cn.com/problems/count-good-numbers/
 *
 */
public class P035 {

    static int count = 0;
    public static int countGoodNumbers(long n) {
        dfs(0,(int)n,new StringBuilder());
        return count;
    }
    public static void dfs(int i, int n, StringBuilder sb){
        if(i>=n){
            String s =sb.toString();
            for (int j = 0; j < n; j++) {
                int a = s.charAt(j)-'0';
                if(j%2==0){
                    if( a % 2 !=0){
                        break;
                    }
                }else{
                    if(a!=2 && a!=3 && a!=7 && a!=5){
                        break;
                    }
                }
                if(j==n-1){
                    count++;
                }
            }
        }else{
            int N=10;
            for (int j = 0; j < N; j++) {
                StringBuilder ss=new StringBuilder(sb);
                ss.append((char)('0'+j));
                dfs(i+1,n,ss);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(countGoodNumbers(n));
        scanner.close();
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