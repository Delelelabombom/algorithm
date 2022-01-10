package carl.栈与队列;

import java.util.Stack;

/**
 * https://programmercarl.com/1047.%E5%88%A0%E9%99%A4%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B8%AD%E7%9A%84%E6%89%80%E6%9C%89%E7%9B%B8%E9%82%BB%E9%87%8D%E5%A4%8D%E9%A1%B9.html#%E9%A2%98%E5%A4%96%E8%AF%9D
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/27 14:10
 */
public class 删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == s.charAt(i)) {
                    while (!stack.empty() && stack.peek() == s.charAt(i)) {
                        stack.pop();
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
