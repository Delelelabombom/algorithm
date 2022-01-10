package carl.backtrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 * leetCode77
 *
 * https://programmercarl.com/0077.%E7%BB%84%E5%90%88.html#%E5%9B%9E%E6%BA%AF%E6%B3%95%E4%B8%89%E9%83%A8%E6%9B%B2
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 */
public class Combinations {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    private void backTracking(int n, int k, int startIndex) {
        if(path.size() == k){
            result.add(new LinkedList<Integer>(path));
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return result;
    }


    /**
     * 剪枝优化
     *
     * ！！！Carl使用path.size()，而我第一次使用startIndex
     *      startIndex无法区分之前的数字是选过了还是没选
     *      而paath.size()可以
     *
     * @param n
     * @param k
     * @param startIndex
     */
    private void backTracking1(int n, int k, int startIndex) {
        if(path.size() == k){
            result.add(new LinkedList<Integer>(path));
        }
        for (int i = startIndex; i <= n - k + 1 + path.size(); i++) {

            /**
             *    k > n - startIndex + 1时 错误！
             *    应为path.size() + n - i + 1 >= k
             *    变换后
             *    i <= n - k + 1 + path.size()
             *      path.size()一定小于k 因为前面的if判定if(path.size() == k){
             *             result.add(new LinkedList<Integer>(path));
             *         }
             *
             *      所以 n - k + 1 + path.size() <= n
             *
             *
             */
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine1(int n, int k) {
        backTracking1(n, k, 1);
        return result;
    }

}
