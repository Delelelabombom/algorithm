package carl.array;

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
public class 螺旋矩阵Ⅱ {
    int[][] result;
    public int[][] generateMatrix(int n) {
        result = new int[n][n];
        fuc(1, n, 1);
        return result;
    }

    /**
     *
     *
     *
     * @param start 子矩阵第一个元素的下标
     * @param n 子矩阵的维度
     * @param k 第k次递归
     */
    public void fuc(int start, int n, int k) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            result[k - 1][k - 1] = start;
            return;
        }
        int s = start;
        for (int i = 0; i < n; i++) {
            result[k - 1][k - 1 + i] = start + i;
            s = start + i;
        }
        int ss = s;
        for (int i = 0; i < n; i++) {
            result[k - 1 + i][k - 1 + n - 1] = s + i;
            ss = s + i;
        }
        int sss = ss;
        for (int i = 0; i < n; i++) {
            result[k - 1 + n - 1][k - 1 + n - 1 - i] = ss + i;
            sss = ss + i;
        }
        int ssss = sss;
        for (int i = 0; i < n - 1; i++) {
            result[k - 1 + n - 1 - i][k - 1] = sss + i;
            ssss = sss + i;
        }

        fuc(ssss + 1, n - 2, k + 1);

    }
}
