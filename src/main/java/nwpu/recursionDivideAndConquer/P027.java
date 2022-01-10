package nwpu.recursionDivideAndConquer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;


public class P027 {

    /**
     * op1 < op2时返回true， 反之false
     * @param op1
     * @param op2
     * @return
     */
    public static boolean priority(String op1, String op2) {
        if (op1.matches("[+|-]") && op2.matches("[*|/]")) {
            return true;
        }
        return false;
    }

    public static List<String> mid2Post(String[] midExpression) {
        Stack<String> operator = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < midExpression.length; i++) {
            String c = midExpression[i];
            if (c.equals("(")) {
                operator.push(c);

            } else if (c.matches("\\d+")) {

                list.add(c);


            } else if (c.matches("[-|+|*|/]")) {
                if (operator.isEmpty()) {
                    operator.push(c);
                }else if (operator.peek().matches("[+|-]") && c.matches("[*|/]")) {
                    operator.push(c);
                } else {
                    /**
                     * b.当运算符栈不为空时且栈顶操作符的优先级大于或等于当前运算符优先级时，
                     * 循环执行出栈操作并加入list中，直到遇到优先级小于当前运算符的元素为止。
                     * 循环执行完后再将当前运算符压栈。另外需要注意的是，只有遇到右括号时，左括号才出栈
                     */
                    String top = operator.peek();
                    while (!operator.isEmpty() && !priority(top, c)) {
                        if (top.equals("(")) {
                            break;
                        }
                        operator.pop();
                        list.add(top);
                        if (!operator.isEmpty()) {
                            top = operator.peek();
                        }
                    }
                    operator.push(c);
                }

            } else if (c.equals(")")) {
                String top = operator.pop();
                while (!top.equals("(")) {
                    list.add(top);
                    top = operator.pop();
                }
            }
        }

        while (!operator.isEmpty()) {
            list.add(operator.pop());
        }

        return list;
    }

    public static int fuc(List<String> list){
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : list) {
            if(s.matches("\\d+")) {
                stack.push(Integer.parseInt(s));
            }
            if(s.matches("[-|+|*|/|%]")) {
                int b = stack.pop();
                int a;
                if (stack.isEmpty()) {
                    a = 0;
                }else {
                    a = stack.pop();
                }
                int c;
                if(s.equals("+")){
                    c = a + b;
                    stack.push(c);
                }
                if(s.equals("-")){
                    c = a - b;
                    stack.push(c);
                }
                if(s.equals("*")){
                    c = a * b;
                    stack.push(c);
                }
                if(s.equals("/")){
                    c = a / b;
                    stack.push(c);
                }
                if(s.equals("%")){
                    c = a % b;
                    stack.push(c);
                }

            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        try{
            String midExpression = Reader.nextLine();

            String[] strings = midExpression.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)|(?<=\\D)(?=\\D)");

            List<String> list = mid2Post(strings);
            System.out.println(fuc(list));
        } catch (Exception e) {

        }



//        int count = 0;
//        for (int i = 0; i < strings.length; i++) {
//            if (i != 0 && strings[i].matches("\\d") && strings[i - 1].matches("\\d")) {
//                count++;
//            }
//        }
//        String[] strings1 = new String[strings.length - count];
//        for (int i = 0, j = 0; i < strings1.length && j < strings.length; i++, j++) {
//            String s = "";
//            while (j != strings.length - 1 && strings[j].matches("\\d") && strings[j + 1].matches("\\d")) {
//                s += strings[j];
//                j++;
//            }
//            s += strings[j];
//            strings1[i] = s;
//        }




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
