package carl.string;

/**
 *
 * https://programmercarl.com/0459.%E9%87%8D%E5%A4%8D%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2.html
 *
 *https://leetcode-cn.com/problems/repeated-substring-pattern/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/21 0:14
 */
public class 重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) {
            return false;
        }
        int[] next = new int[s.length()];
        getNext(next, s);
        int len = s.length();
        if (next[len - 1] != 0 && len % (len - next[len - 1]) == 0) {
            return true;
        }
        return false;
    }

    public void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}
