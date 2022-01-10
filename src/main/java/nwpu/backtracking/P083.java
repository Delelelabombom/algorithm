package nwpu.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * https://leetcode-cn.com/problems/generate-parentheses/solution/shen-du-you-xian-bian-li-zui-jian-jie-yi-ypti/
 *
 *
 */
public class P083 {

    static List<String> res = new ArrayList<String>();  //记录答案

    static int result = 0;

    public static List<String> generateParenthesis(int n) {
        res.clear();
        dfs(n, 0, 0, "");
        return res;
    }
    public static void dfs(int n ,int lc, int rc ,String str)
    {
        if( lc == n && rc == n) {//递归边界
            result++;
            //res.add(str);
        }
        else {
            if(lc < n) dfs(n, lc + 1, rc, str + "(");            //拼接左括号
            if(rc < n && lc > rc) dfs(n, lc, rc + 1, str + ")"); //拼接右括号
        }
    }


    public static void main(String[] args) {
        try {
            int n = Reader.nextInt();
            generateParenthesis(n);
            System.out.println(result);

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



