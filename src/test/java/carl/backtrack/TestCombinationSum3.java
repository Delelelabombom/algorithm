package carl.backtrack;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * https://programmercarl.com/0216.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8CIII.html#%E5%9B%9E%E6%BA%AF%E4%B8%89%E9%83%A8%E6%9B%B2
 *
 *找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 *
 * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]v
 *
 *
 */
public class TestCombinationSum3 {

    public void testCombin(int k, int n){
        CombinationSum3 combinationSum3 = new CombinationSum3();
        List<List<Integer>> lists = combinationSum3.combinationSum3(k, n);
        System.out.println(lists);
        System.out.println("//////////////////////");
    }


    @Test
    public void test1(){
        testCombin(3, 7);
        testCombin(3, 9);
        testCombin(2, 18);

    }


}
