package nwpu.bruteForce;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;


/**
 *
 * Description
 *
 * 给你一个中缀表达式，请将其转换为后缀表达式，并输出。
 *
 * 如：( 1 + 2 ) * 3，将其转换为后缀表达式为：1 2 + 3 *
 *
 *
 * Input
 * 中缀表达式的值，元素之间用空格分隔。
 *
 * 如：( 1 + 2 ) * ( 3 + 4 )
 *
 *
 * Output
 * 转换后的后缀表达式的值，元素之间用空格分隔。
 *
 * 如：1 2 + 3 4 + * (结尾这里有个空格)
 *
 *
 * Sample Input 1
 *
 * ( 1 + 2 ) * 3
 * Sample Output 1
 *
 * 1 2 + 3 *
 * Sample Input 2
 *
 * ( 70 + 30 ) * 20 + 10 / 2 - 3
 * Sample Output 2
 *
 * 70 30 + 20 * 10 2 / + 3 -
 * Hint
 *
 * 规则如下：
 *
 * 1）我们使用一个stack栈结构存储操作符，用一个List队列结构存储后缀表达式结果
 *
 * 2）若读取到数字，直接存入list中
 *
 * 3）当读取到左括号"("时，直接压栈，当读取到运算符时，分两种情况讨论
 *
 * a.当运算符栈为空或者栈顶操作符的优先级小于当前运算符优先级时(如+和-的优先级低于 * 和 /)，直接入栈
 *
 * b.当运算符栈不为空时且栈顶操作符的优先级大于或等于当前运算符优先级时，循环执行出栈操作并加入list中，直到遇到优先级小于当前运算符的元素为止。循环执行完后再将当前运算符压栈。另外需要注意的是，只有遇到右括号时，左括号才出栈
 *
 * 4) 当遇到右括号")"时，循环执行出栈操作并加入到list中，直到遇到左括号为止。并将左括号弹出，但不加入list中
 *
 * 5) 表达式的值读取完后，将操作符栈中的所有元素弹出并加入到list中
 *
 * 执行完上面步骤后，list中存储的顺序即为我们转换后的后缀表达式的结果
 */
public class P009 {

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
//                if (i + 1 < midExpression.length()) {
//                    if (String.valueOf(midExpression.charAt(i + 1)).matches("//d")) {
//                        i++;
//                        c += String.valueOf(midExpression.charAt(i));
//                    }
//                }

//                while ((i + 1) < midExpression.length && String.valueOf(midExpression.charAt(i + 1)).matches("//d")) {
//                    i++;
//                    c += String.valueOf(midExpression.charAt(i));
//                }

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

    public static void main(String[] args) {
        //System.out.println("-".matches("[-|+|*|/]"));
        Scanner scanner = new Scanner(System.in);
        String midExpression = scanner.nextLine();
        String[] strings = midExpression.split(" ");
        List<String> list = mid2Post(strings);
        for (String s : list) {
            System.out.print(s);
            System.out.print(" ");
        }



        scanner.close();
    }
}
