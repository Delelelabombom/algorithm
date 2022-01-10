package carl.hashMap;

import java.util.HashMap;

/**
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/16 15:32
 *
 * https://leetcode-cn.com/problems/4sum-ii/
 * https://programmercarl.com/0454.%E5%9B%9B%E6%95%B0%E7%9B%B8%E5%8A%A0II.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 */
public class 四数之和 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                hashMap.put(nums1[i] + nums2[j], hashMap.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (hashMap.get(-nums3[i] - nums4[j]) != null) {
                    result += hashMap.get(-nums3[i] - nums4[j]);
                }
            }
        }
        return result;
    }
}
