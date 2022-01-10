package carl.array;

/**
 * https://programmercarl.com/0209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.html#_209-%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84
 *https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class 长度最小子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int currentSum = 0;
        int lo = 0;
        for (int hi = 0; hi < nums.length; hi++) {
            currentSum += nums[hi];
            while (currentSum >= target) {
                minLen = Integer.min(minLen, hi - lo + 1);
                currentSum -= nums[lo++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
