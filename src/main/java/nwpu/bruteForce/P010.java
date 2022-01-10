package nwpu.bruteForce;

import java.util.Scanner;

/**
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
 *
 *
 * Description
 *
 * 给你一个字符串A，一个字符串B，返回字符串A中全覆盖字符串B所有字符的最小子串。
 *
 * 所谓A子串全覆盖B就是：A子串中每个字符出现的频率大于等于B中每个字符出现的频率。
 *
 *
 * Input
 * 输入一个字符串A和一个字符串B，如：
 *
 * aboard
 *
 * aa
 *
 *
 * Output
 * 返回的子串满足两个条件：
 *
 * 1.该子串全覆盖B
 *
 * 2.长度尽可能小
 *
 * 比如上面输入的答案：aboa
 *
 *
 * Sample Input 1
 *
 * bewilderment
 * bde
 * Sample Output 1
 *
 * bewild
 * Hint
 *
 * 1.测试用例中满足条件的子串是唯一的，不用考虑多种情况
 *
 * 2.A字符串的长度只有大于等于B字符串的长度时才可能有解（特殊情况需要处理）Description
 *
 * 给你一个字符串A，一个字符串B，返回字符串A中全覆盖字符串B所有字符的最小子串。
 *
 * 所谓A子串全覆盖B就是：A子串中每个字符出现的频率大于等于B中每个字符出现的频率。
 *
 *
 * Input
 * 输入一个字符串A和一个字符串B，如：
 *
 * aboard
 *
 * aa
 *
 *
 * Output
 * 返回的子串满足两个条件：
 *
 * 1.该子串全覆盖B
 *
 * 2.长度尽可能小
 *
 * 比如上面输入的答案：aboa
 *
 *
 * Sample Input 1
 *
 * bewilderment
 * bde
 * Sample Output 1
 *
 * bewild
 * Hint
 *
 * 1.测试用例中满足条件的子串是唯一的，不用考虑多种情况
 *
 * 2.A字符串的长度只有大于等于B字符串的长度时才可能有解（特殊情况需要处理）
 */
public class P010 {

    private static final String solution(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return "";
        }
        if (str2.length() == 0) {
            return "";
        }

        int[] need = new int[128];
        for (int i = 0; i < str2.length(); i++) {
            need[str2.charAt(i)]++;
        }

        int left = 0, right = 0, size = Integer.MAX_VALUE,
                count = str2.length(), start = 0;
        while (right < str1.length()) {
            char c = str1.charAt(right);
            if (need[c] > 0) {
                count--;
            }
            need[c]--;

            if (count == 0) {
                while (left < right && need[str1.charAt(left)] < 0) {
                    need[str1.charAt(left)]++;
                    left++;
                }

                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }

                need[str1.charAt(left)]++;
                left++;
                count++;
            }

            right++;
        }

        return size == Integer.MAX_VALUE ? "" : str1.substring(start, start + size);

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();;
        String str2 = scanner.nextLine();
        System.out.println(solution(str1, str2));



        scanner.close();
    }
}
