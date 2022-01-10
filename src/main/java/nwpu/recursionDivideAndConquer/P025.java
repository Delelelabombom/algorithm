package nwpu.recursionDivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P025 {


    public static void main(String[] args) {
        try {
            String s1 = Reader.nextLine();
            String s2 = Reader.nextLine();
            if (s1.equals("")){
                s1 = s2;
            }else {
                s1 = s1 + "," + s2;
            }

            String[] strings = s1.split(",");
            int [] list = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                list[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(list);
            if ((list.length & 1) == 1) {
                System.out.println(list[list.length / 2]);
            } else {
                int a = list[list.length / 2];
                int b = list[list.length / 2 - 1];
                double d = ((double)a + (double)b) /2.0;
                if (d == (double) (int)d) {
                    System.out.println((int)d);
                }else {
                    System.out.println(d);
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



