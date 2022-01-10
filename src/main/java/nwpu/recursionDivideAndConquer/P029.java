package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P029 {


    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            int m = Reader.nextInt();
            String[] strings = string.split(",");
            int[] list = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                list[i] = Integer.parseInt(strings[i]);
            }

            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i : list) {
                if (hashMap.get(i) == null) {
                    hashMap.put(i, 1);
                }else {
                    hashMap.put(i, hashMap.get(i) + 1);
                }
            }

            List<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(hashMap.entrySet());

            Collections.sort(list1, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            int[] result = new int[m];
            Iterator<Map.Entry<Integer, Integer>> iterator = list1.iterator();

            for (int i = 0; i < m; i++) {
                Map.Entry<Integer, Integer> item = iterator.next();
                result[i] = item.getKey();
            }
            Arrays.sort(result);
            String s = "";
            for (int i : result) {
                s += i;
                s += ",";
            }

            s = s.substring(0, s.length() - 1);
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


