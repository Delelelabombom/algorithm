package carl.栈与队列;

import org.junit.Test;

import java.util.Stack;

/**
 * https://programmercarl.com/0150.%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%B1%82%E5%80%BC.html
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/27 14:21
 */
public class 逆波兰表达式Test {

    @Test
    public void test(){
        逆波兰表达式 a =new 逆波兰表达式();
        String[] b = {"2","1","+","3","*"};
        int res = a.evalRPN(b);
        System.out.println();
    }
    @Test
    public void tes2t(){
        逆波兰表达式 a =new 逆波兰表达式();
        String[] b = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int res = a.evalRPN1(b);
        System.out.println();
    }

    @Test
    public void test3(){
        逆波兰表达式 a =new 逆波兰表达式();
        String[] b = {"0","3","/"};
        int res = a.evalRPN1(b);
        System.out.println();
    }
}
