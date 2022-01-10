package carl.栈与队列;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmercarl.com/0239.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%9C%80%E5%A4%A7%E5%80%BC.html
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/6 18:46
 */
public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            //先结算， 返回最大值
            result[i - k] = queue.front();
            //再移动窗口
            queue.pop(nums[i - k]);
            queue.push(nums[i]);
        }
        //最后结算收尾
        result[result.length - 1] = queue.front();
        return result;
    }

    class MyQueue {
        Deque<Integer> queue;
        MyQueue() {
            queue = new LinkedList<Integer>();
        }
        void push(int value) {
            while (!queue.isEmpty() && queue.peekLast() < value) {
                queue.removeLast();
            }
            queue.add(value);
        }
        void pop(int value) {
            if (value == front()) {
                queue.poll();
            }

        }
        int front() {
            return queue.peek();
        }
    }
}
