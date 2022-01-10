package nwpu.bruteForce;

import java.util.Scanner;

/**
 *
 *
 * https://www.bilibili.com/video/BV11E411j7TM
 *
 * Description
 *
 * 给你一个字符串，找到其中最长的对称子串。（对称子串通俗来讲就是正着读和倒着读一样）。
 *
 *
 *
 * Input
 * 输入一个字符串，如s="mbabca"。
 *
 *
 * Output
 * “bab”为最长的对称子串，输出“bab”。
 *
 * 若答案多种情况则取从左往右第一种情况，如s="babad","bab"和"aba"都符合题意，取第一种情况"bab"输出。
 *
 *
 * Sample Input 1
 *
 * babad
 * Sample Output 1
 *
 * bab
 */
public class P005 {


    static String expand(String string) {
        String str = "*#";
        for (int i = 0; i < string.length(); i++) {
            str += string.charAt(i);
            str += "#";
        }
        return str;
    }

    static String manacher(String s) {
        String string = expand(s);
        int center = 0, maxIndex = 0;
        int[] radius = new int[string.length()];
        int maxlen = 0;
        int start = 0;

        for (int i = 0; i < string.length(); i++) {
            if(i < maxIndex) {//i 在半径里面
                radius[i] = Math.min(radius[2 * center - i], maxIndex - i);
            }else {
                radius[i] = 1;
            }

            for(; i + radius[i] < string.length() && i - radius[i] > 0
            && string.charAt(i + radius[i]) == string.charAt(i - radius[i]); radius[i]++);

            if (radius[i] + i > maxIndex) {
                maxIndex = radius[i] + i;
                center = i;
            }

            if (radius[i] - 1 > maxlen) {
               maxlen = radius[i] - 1;
               start = (center - maxlen) / 2;
            }
        }

        return s.substring(start, start + maxlen);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(manacher(s));
    }


    public static void test(String[] args) {
        System.out.println(3/2);
        String s = "abcdcbafabcdck";
        String s1 = "cbbd";
        System.out.println(manacher(s));


    }



}
