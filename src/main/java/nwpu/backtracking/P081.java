package nwpu.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Description
 *
 * 给你一个数字sum，再给k个数字num1、num2、...、numk，现在需要将k个数字进行组合，使得他们的和为sum。请问有多少种组合？如果任何组合的和都不等于sum，返回0。
 *
 *
 * Input
 * 第一行输入数字sum，第二行输入数字个数k，接下来k行分别输入k个数字。
 *
 *
 * Output
 * 输出组合的个数。
 *
 *
 * Sample Input 1
 *
 * 5
 * 3
 * 1
 * 2
 * 5
 * Sample Output 1
 *
 * 4
 * Sample Input 2
 *
 * 3
 * 1
 * 2
 * Sample Output 2
 *
 * 0
 * Sample Input 3
 *
 * 10
 * 1
 * 10
 * Sample Output 3
 *
 * 1
 */
public class P081 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new LinkedList<>();
    static int sum = 0;

    /**
     *  oj失败原因： 不断new LinkedList<>(path)
     * @param target
     * @param list
     * @param startIndex
     */

    public static final void backTracking(int target, int[] list, int startIndex) {
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < list.length; i++) {
            if (sum + list[i] > target) {
                break;
            }
            path.add(list[i]);
            sum += list[i];
            backTracking(target, list, i);
            sum -= list[i];
            path.remove(path.size() - 1);


        }



    }

    public static void main(String[] args) {


        try {
            int target = Reader.nextInt();
            int size = Reader.nextInt();
            int[] list = new int[size];
            for (int i = 0; i < size; i++) {
                list[i] = Reader.nextInt();
            }
            Arrays.sort(list);

            backTracking(target, list, 0);
            System.out.println(result.size());
        }catch (IOException e) {

        }



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


