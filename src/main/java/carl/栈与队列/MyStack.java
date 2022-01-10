package carl.栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * https://programmercarl.com/0225.%E7%94%A8%E9%98%9F%E5%88%97%E5%AE%9E%E7%8E%B0%E6%A0%88.html
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/27 13:30
 *
 * !!! 一个queue就够啦！
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        Queue<Integer> queue = queueUsing();
        queue.add(x);
    }

    public int pop() {
        Queue<Integer> queueUsing = queueUsing();
        Queue<Integer> queueNotUsing = queueNotUsing();
        while (queueUsing.size() != 1) {
            queueNotUsing.add(queueUsing.poll());
        }
        return queueUsing.poll();
    }

    public int top() {
        int top = pop();
        push(top);
        return top;
    }

    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }

    private Queue queueUsing() {
        if (queue1.isEmpty()) {
            return queue2;
        } else {
            return queue1;
        }
    }

    private Queue queueNotUsing() {
        if (queue1.isEmpty()) {
            return queue1;
        } else {
            return queue2;
        }
    }
}
