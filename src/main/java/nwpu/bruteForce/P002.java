package nwpu.bruteForce;


import java.util.Scanner;
import java.util.Stack;
import java.util.*;

/**
 * Description
 *
 * 给你一个后缀表达式，请计算其结果并输出。
 *
 * 比如中缀表达式：( 1 + 2 ) * 3  对应的后缀表达式为: 1 2 + 3 *,其计算结果为9。
 *
 * 给定的后缀表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 *
 * Input
 * 输入一行后缀表达式，元素之间空格分隔。
 *
 *
 * Output
 * 输出中缀表达式的计算结果。
 *
 *
 * Sample Input 1
 *
 * 1 2 + 3 *
 * Sample Output 1
 *
 * 9
 * Hint
 *
 * 结果没有出现浮点数
 */
public class P002 {
    static String string;

    static int fuc(){
        String[] strings = string.split(" ");
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : strings) {
            if(s.matches("\\d+")) {
                stack.push(Integer.parseInt(s));
            }
            if(s.matches("[-|+|*|/|%]")) {
                int b = stack.pop();
                int a = stack.pop();
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
        Scanner scanner = new Scanner(System.in);
        string = scanner.nextLine();

        int res = fuc();

        System.out.print(Integer.toString(res));
        scanner.close();
    }


}
