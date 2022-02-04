package carl.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 113
 * https://programmercarl.com/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.html#%E8%BF%AD%E4%BB%A3
 * https://leetcode-cn.com/problems/path-sum-ii/
 * @author LiPeishu
 * @version 1.0
 * @description: 路径总和ii要遍历整个树，找到所有路径，所以递归函数不要返回值！
 * @date 2022/1/30 9:58
 */
public class 路径总和ii {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {


        if (root == null) {
            return results;
        }
        traverse(root, 0, targetSum);
        return results;

    }
    private void traverse(TreeNode root, int currentSum, int targetSum) {
        if (root.right == null && root.left == null) {
            currentSum += root.val;
            if (currentSum == targetSum) {
                path.add(root.val);
                results.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        path.add(root.val);
        if (root.left != null) {
            traverse(root.left, currentSum + root.val, targetSum);
        }

        if (root.right != null) {
            traverse(root.right, currentSum + root.val, targetSum);
        }
        path.remove(path.size() - 1);
        return ;
    }


}
