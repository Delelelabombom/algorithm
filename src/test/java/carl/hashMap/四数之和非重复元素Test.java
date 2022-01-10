package carl.hashMap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmercarl.com/0018.%E5%9B%9B%E6%95%B0%E4%B9%8B%E5%92%8C.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 *
 * https://leetcode-cn.com/problems/4sum/
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/17 15:58
 */
public class 四数之和非重复元素Test {
    @Test
    public void test() {
        int target = 0;
        int[] nums = {1,0,-1,0,-2,2};
        四数之和非重复元素 a = new 四数之和非重复元素();
        List<List<Integer>> re = a.fourSum(nums, target);
        System.out.println();
    }

    @Test
    public void test1() {
        int target = 8;
        int[] nums = {2,2,2,2,2};
        四数之和非重复元素 a = new 四数之和非重复元素();
        List<List<Integer>> re = a.fourSum(nums, target);
        System.out.println();
    }


}
