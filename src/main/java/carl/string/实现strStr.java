package carl.string;

/**
 *
 * https://programmercarl.com/0028.%E5%AE%9E%E7%8E%B0strStr.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/21 0:16
 */
public class 实现strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
         getNext(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }

            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
     }

    public void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while(j>=0 && s.charAt(i) != s.charAt(j+1)){
                j=next[j];
            }
            if(s.charAt(i)==s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
    }
}
