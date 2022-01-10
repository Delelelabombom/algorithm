package carl.hashMap;

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
public class 三数之和 {
    /**
     * hashmap法难以去重，双指针法更好
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i] ,hashMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j =  i + 1; j < nums.length; j++) {
                if (hashMap.get(-nums[i] - nums[j]) != null) {
                    int count = hashMap.get(-nums[i] - nums[j]);
                    if ((-nums[i] - nums[j]) == nums[i]) {
                        count--;
                    }
                    if ((-nums[i] - nums[j]) == nums[j]) {
                        count--;
                    }
                    if (count > 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(-nums[i] - nums[j]);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int right = nums.length - 1;
            int left = i + 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
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
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }


}
