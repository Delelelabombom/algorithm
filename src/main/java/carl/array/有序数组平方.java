package carl.array;

/**
 *https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *https://programmercarl.com/0977.%E6%9C%89%E5%BA%8F%E6%95%B0%E7%BB%84%E7%9A%84%E5%B9%B3%E6%96%B9.html#%E6%9A%B4%E5%8A%9B%E6%8E%92%E5%BA%8F
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100] 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
 */
public class 有序数组平方 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k] = nums[i] * nums[i];
                i++;
            }else {
                result[k] = nums[j] * nums[j];
                j--;
            }
            k--;
        }

        return result;
    }
}
