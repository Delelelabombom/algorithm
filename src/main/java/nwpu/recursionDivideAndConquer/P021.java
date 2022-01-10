package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * https://cloud.tencent.com/developer/article/1880933
 *
 *
 */
public class P021 {

    static HashMap<String, List<Integer>> memo = new HashMap<>();

    public static List<Integer> diffWaysToCompute(String input) {

        if (memo.containsKey(input)) {
            return memo.get(input);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for (Integer a : left) {
                    for (Integer b : right) {
                        if (c == '+') {
                            result.add(a + b);
                        }else if (c == '-') {
                            result.add(a - b);
                        }else if (c == '*') {
                            result.add(a * b);
                        }
                    }
                }
            }
            

        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }

        memo.put(input, result);
        return result;
    }


    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            if (!string.isEmpty()) {
                List<Integer> list = diffWaysToCompute(string);
                //List<Integer> newList = new ArrayList<Integer>(new HashSet<Integer>(list));
                list.sort(Comparator.naturalOrder());
                System.out.print(list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    System.out.print(" ");
                    System.out.print(list.get(i));
                }
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

