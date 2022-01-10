package carl.string;

/**
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * https://programmercarl.com/%E5%89%91%E6%8C%87Offer58-II.%E5%B7%A6%E6%97%8B%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2.html
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/19 10:45
 */
public class 左旋转反转字符串 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder(s);
        reverse(0, n - 1, stringBuilder);
        reverse(n, stringBuilder.length() - 1, stringBuilder);
        reverse(0, stringBuilder.length() - 1, stringBuilder);

        return stringBuilder.toString();
    }

    private void reverse(int lo, int hi, StringBuilder stringBuilder) {
        while (lo < hi) {{
            char temp = stringBuilder.charAt(lo);
            stringBuilder.setCharAt(lo, stringBuilder.charAt(hi));
            stringBuilder.setCharAt(hi, temp);
            lo++;
            hi--;
        }}
    }
}
