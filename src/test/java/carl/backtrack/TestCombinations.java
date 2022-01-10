package carl.backtrack;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 * leetCode77
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 */
public class TestCombinations {
    Combinations combinations = new Combinations();

    @Test
    public void TestComb1(){
        List<List<Integer>> result = combinations.combine(4, 2);
        System.out.println(result);
    }


}
