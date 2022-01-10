package carl.栈与队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * https://programmercarl.com/0347.%E5%89%8DK%E4%B8%AA%E9%AB%98%E9%A2%91%E5%85%83%E7%B4%A0.html
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/7 14:28
 */
public class 前k个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            result[k - i - 1] = queue.poll().getKey();
        }
        return result;
    }
}
