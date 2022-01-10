package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P030 {

    public static final String repeatString(int repeat, String s) {
        String temp = s;
        while ( repeat > 1) {
            s += temp;
            repeat--;
        }
        return s;
    }

    public static String solve(String[] strings) {
        Stack<String> stack = new Stack();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("]")) {
                String s = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    String top = stack.pop();
                    if (top.matches("[a-z]+")) {
                        s+=top;
                    }
                }
                stack.pop();
                if (!stack.isEmpty() && stack.peek().matches("\\d+")) {
                    int repeat = Integer.parseInt(stack.pop());
                    s = repeatString(repeat, s);
                }

                while (!stack.isEmpty() && stack.peek().matches("[a-z]+")) {
                    String top = stack.pop();
                    s = top + s;
                }

                stack.push(s);


            } else if (strings[i].matches("\\d")) {
                String repeat = strings[i];
                while (i + 1 < strings.length && strings[i + 1].matches("\\d")) {
                    i++;
                    repeat += strings[i];
                }
                stack.push(repeat);
            } else if (strings[i].equals("[")) {
                stack.push(strings[i]);
            } else { //字母
                String s = strings[i];
                while (i + 1 < strings.length && strings[i + 1].matches("[a-z]+")) {
                    i++;
                    s += strings[i];
                }
                stack.push(s);
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        try {
            String string = Reader.nextLine();
            String[] strings = string.split("");
            String result = solve(strings);
            System.out.println(result);
            result = result.substring(1, result.length() - 1);
            result = result.replace(" ", "");
            result = result.replace(",", "");

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


