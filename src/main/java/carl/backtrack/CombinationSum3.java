package carl.backtrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * https://programmercarl.com/0216.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8CIII.html#%E5%9B%9E%E6%BA%AF%E4%B8%89%E9%83%A8%E6%9B%B2
 *
 *找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 *
 * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]v
 *
 *
 */
public class CombinationSum3 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int pathSum = 0;

    private void backTracking(int k, int n, int startIndex){
        if(path.size() == k && pathSum == n){
            result.add(new LinkedList<Integer>(path));
        }

        for (int i = startIndex; i <= 9; i++) {

            if(pathSum + i <= n){
                path.add(i);
                pathSum += i;

                backTracking(k, n, i + 1);
                path.removeLast();
                pathSum -= i;

            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1);
        return result;
    }


    /**
     * 通过！尝试剪枝
     *wwww不用剪了！已经剪完啦
     * @param k
     * @param n
     * @param startIndex
     */
    private void backTracking1(int k, int n, int startIndex){
        if(path.size() == k && pathSum == n){
            result.add(new LinkedList<Integer>(path));
        }

        for (int i = startIndex; i <= 9; i++) {

            if(pathSum + i <= n){
                path.add(i);
                pathSum += i;

                backTracking1(k, n, i + 1);
                path.removeLast();
                pathSum -= i;

            }
        }
    }


    public List<List<Integer>> combinationSum31(int k, int n) {
        backTracking1(k, n, 1);
        return result;
    }

}
