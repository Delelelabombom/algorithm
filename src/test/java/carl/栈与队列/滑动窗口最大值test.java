package carl.栈与队列;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://programmercarl.com/0239.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%9C%80%E5%A4%A7%E5%80%BC.html
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/6 18:46
 */
public class 滑动窗口最大值test {
    @Test
    public void Test(){
        滑动窗口最大值 a = new 滑动窗口最大值();
        int[] aa = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] r = a.maxSlidingWindow(aa, k);
        System.out.println();
    }
}
