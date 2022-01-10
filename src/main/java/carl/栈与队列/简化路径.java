package carl.栈与队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/7 15:01
 */
public class 简化路径 {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String string : strings) {
            if (string.equals(".")) {
                continue;
            }
            else if (string.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            }
            else if (string.equals("")) {
                continue;
            }
            else {
                //正常路径名
                stack.push(string);
            }
        }
        if (stack.size() == 0) {
            return "/";
        }
        String[] strings1 = stack.toArray(new String[stack.size()]);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings1) {
            stringBuilder.append("/");
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
}
