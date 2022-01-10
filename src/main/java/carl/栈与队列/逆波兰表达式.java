package carl.栈与队列;

import java.util.Stack;

/**
 * https://programmercarl.com/0150.%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%B1%82%E5%80%BC.html
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/27 14:21
 */
public class 逆波兰表达式 {
    private boolean isNumbers(String s) {
        return s.matches("[1-9]\\d*") || s.matches("-[1-9]\\d*")|| s.matches("0");
    }

    private boolean isOperator(String s) {
        return s.matches("[-|+|*|/]");
    }

    private boolean priority(String currentOperator, String previousOperator) {
        if (currentOperator.matches("[*|/]")) {
            return true;
        }
        return false;
    }

    private int calculate(int a, int b, String operator) {
        if (operator.equals("*")) {
            return a*b;
        } else if (operator.equals("/")){
            return a/b;
        } else if (operator.equals("+")){
            return a+b;
        } else {
            return a-b;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<String> operatorsStack = new Stack<>();
        Stack<String> numbersStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNumbers(tokens[i])) {
                numbersStack.push(tokens[i]);
            } else if (isOperator(tokens[i])) {
                if (!operatorsStack.isEmpty()) {
                    while (!operatorsStack.isEmpty() && !priority(tokens[i], operatorsStack.peek())) { //当前operator比之前优先级低
                        int b = Integer.parseInt(numbersStack.pop());
                        int a = Integer.parseInt(numbersStack.pop());
                        String operator = operatorsStack.pop();
                        numbersStack.push(Integer.toString(calculate(a, b, operator)));
                    }
                }
                operatorsStack.push(tokens[i]);
            }
        }
        while (!operatorsStack.isEmpty()) { //当前operator比之前优先级低
            int b = Integer.parseInt(numbersStack.pop());
            int a = Integer.parseInt(numbersStack.pop());
            String operator = operatorsStack.pop();
            numbersStack.push(Integer.toString(calculate(a, b, operator)));
        }
        return Integer.parseInt(numbersStack.pop());
    }

    public int evalRPN1(String[] tokens) {
        Stack<String> numbersStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNumbers(tokens[i])) {
                numbersStack.push(tokens[i]);
            } else if (isOperator(tokens[i])) {
                int b = Integer.parseInt(numbersStack.pop());
                int a = Integer.parseInt(numbersStack.pop());
                String operator = tokens[i];
                numbersStack.push(Integer.toString(calculate(a, b, operator)));
            }
        }
        return Integer.parseInt(numbersStack.pop());
    }
}
