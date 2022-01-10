package nwpu.recursionDivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P019 {


    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            int m = Reader.nextInt();
            string = string.substring(1, string.length() - 1);
            String[] strings = string.split(",");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {
                list.add(Integer.parseInt(strings[i]));
            }
            list.sort(Comparator.naturalOrder());
            List<Integer> result = list.subList(0, m);
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


