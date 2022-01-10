package carl.hashMap;

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
public class 四数之和非重复元素 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int right = nums.length - 1;
                int left = j + 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    }else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    }else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while ((left + 1 <= nums.length - 1) && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while ((right - 1 >= 0) && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
