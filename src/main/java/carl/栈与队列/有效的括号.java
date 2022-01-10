package carl.栈与队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * https://programmercarl.com/0020.%E6%9C%89%E6%95%88%E7%9A%84%E6%8B%AC%E5%8F%B7.html#%E9%A2%98%E5%A4%96%E8%AF%9D
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/27 13:52
 */
public class 有效的括号 {
    private boolean isPair(Character c, Character cc) {
        switch (c) {
            case ']' : {
                if (cc == '[') {
                    return true;
                }
                break;
            }
            case '}' : {
                if (cc == '{') {
                    return true;
                }
                break;
            }
            case ')' : {
                if (cc == '(') {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
//            if (stack.isEmpty()) {
//                stack.push(s.charAt(i));
//            } else {
//                if (isPair(s.charAt(i), stack.peek())) {
//                    stack.pop();
//                } else {
//                    stack.push(s.charAt(i));
//                }
//            }

            if (!stack.isEmpty() && isPair(s.charAt(i), stack.peek())) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }



        }
        return stack.isEmpty();
    }
}
