package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P018 {

    public static int findReversedPairs(int[] nums, int lo, int hi) {
        int result = 0;
        int mi = (lo + hi) / 2;
        int i = lo, j = mi + 1;
        for (; i <= mi; i++) {
            while (j <= hi && nums[i] > 2 * nums[j]) {
                result += mi - i + 1;
                j++;
            }
        }
        return result;
    }


    public static int solution(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return 0;
        }
        int mi = (lo + hi) / 2;

        int result = solution(nums, lo, mi) +
                solution(nums, mi + 1, hi) +
                findReversedPairs(nums, lo, hi);


        int[] temp = Arrays.copyOfRange(nums, lo, hi + 1);
        Arrays.sort(temp);
        for (int i = lo; i <= hi; i++) {
            nums[i] = temp[i - lo];
        }
        return  result;

    }

    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            string = string.substring(1, string.length() - 1);
            String[] strings = string.split(",");
            int[] list = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                list[i] = Integer.parseInt(strings[i]);
            }
            System.out.println(solution(list, 0, list.length - 1));

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



