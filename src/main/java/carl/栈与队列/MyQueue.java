package carl.栈与队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * https://programmercarl.com/0232.%E7%94%A8%E6%A0%88%E5%AE%9E%E7%8E%B0%E9%98%9F%E5%88%97.html#%E6%80%9D%E8%B7%AF
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/27 13:18
 */
public class MyQueue {
    Stack<Integer> stdinStack;
    Stack<Integer> stdoutStack;
    public MyQueue() {
        stdinStack = new Stack<>();
        stdoutStack = new Stack<>();
    }

    public void push(int x) {
        stdinStack.push(x);
    }

    public int pop() {
        int res = peek();
        stdoutStack.pop();
        return res;
    }

    public int peek() {
        if (stdoutStack.empty()) {
            while (!stdinStack.empty()) {
                stdoutStack.push(stdinStack.pop());
            }
        }
        return stdoutStack.peek();
    }

    public boolean empty() {
        if (stdinStack.empty() && stdoutStack.empty()) {
            return true;
        }
        return false;
    }
}
