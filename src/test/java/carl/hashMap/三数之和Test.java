package carl.hashMap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * https://programmercarl.com/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.html#%E5%93%88%E5%B8%8C%E8%A7%A3%E6%B3%95
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意： 答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 *
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/17 14:47
 */
public class 三数之和Test {

    @Test
    public void test(){
        三数之和 a = new 三数之和();
        int[] b = {0,0,0,0};
        List<List<Integer>> three = a.threeSum1(b);
        System.out.println();
    }

    @Test
    public void test2(){
        三数之和 a = new 三数之和();
        int[] b = {-2,0,0,2,2};
        List<List<Integer>> three = a.threeSum1(b);
        System.out.println();
    }


}
