package carl.string;

import java.util.Stack;

/**
 *  https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * https://programmercarl.com/0151.%E7%BF%BB%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2%E9%87%8C%E7%9A%84%E5%8D%95%E8%AF%8D.html
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/18 10:35
 */
public class 翻转2字符串单词2 {
    public String reverseWords(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (s.charAt(begin) == ' ') {
            begin++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        s = s.substring(begin, end + 1);
        s = s + " ";

        Stack<String> result = new Stack<>();
        int previous = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result.push(s.substring(previous, i));
                while (i + 1 < s.length() && s.charAt(i + 1) == ' ') {
                    i++;
                }
                previous = i + 1;
            }
        }
        String resultString = "";
        int size = result.size();
        for (int i = 0; i < size; i++) {
            resultString = resultString + result.pop() + " ";
        }
        resultString = resultString.substring(0, resultString.length() - 1);
        return  resultString;
    }

    /**
     *
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

}
