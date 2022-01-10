package carl.backtrack;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * https://programmercarl.com/0017.%E7%94%B5%E8%AF%9D%E5%8F%B7%E7%A0%81%E7%9A%84%E5%AD%97%E6%AF%8D%E7%BB%84%E5%90%88.html#%E6%95%B0%E5%AD%97%E5%92%8C%E5%AD%97%E6%AF%8D%E5%A6%82%E4%BD%95%E6%98%A0%E5%B0%84
 *
 *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *示例: 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明：尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
 *
 *
 *
 * 思路 建一个map 2 - abc
 *              3 - def
 *根据输入字符串长度建立
 */
public class TestLetterCombinationsOfAPhoneNumber {


    @Test
    public void test(){
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        letterCombinationsOfAPhoneNumber.letterCombinations("12345");
    }
}
