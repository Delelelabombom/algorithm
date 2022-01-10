package carl.array;

import org.junit.Test;

/**
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * https://programmercarl.com/0059.%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5II.html#_59-%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5ii
 *
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/12 13:54
 */
public class 螺旋矩阵Ⅱtest {
    @Test
    public void test(){
        螺旋矩阵Ⅱ a = new 螺旋矩阵Ⅱ();
        int[][] res  = a.generateMatrix(1);
        System.out.println(res);
    }
}
