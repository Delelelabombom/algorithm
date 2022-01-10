package nwpu.bruteForce;


import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description
 *
 * 现提供一个字符串，请你找出其中最长的，不含有重复字符的子串的长度。
 *
 *
 * Input
 * 输入一个字符串如“abcabcbb”。
 *
 *
 * Output
 * 输出为3，因为无重复字符的最长子串是“abc”，所以其长度为3。
 *
 *
 * Sample Input 1
 *
 * abcabcbb
 * Sample Output 1
 *
 * 3
 */
public class P004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int result = 0;

        int lIndex = 0;
        int rIndex = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (rIndex = 0; rIndex < string.length(); rIndex++) {
            if (map.containsKey(string.charAt(rIndex)) ) {
                lIndex =Math.max(lIndex, map.get(string.charAt(rIndex)) + 1) ;
            }


            result = Math.max(result, rIndex - lIndex + 1);

            map.put(string.charAt(rIndex), rIndex);
        }

        System.out.println(result);

        scanner.close();
    }
}
