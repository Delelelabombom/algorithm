package carl.二叉树;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * https://programmercarl.com/0106.%E4%BB%8E%E4%B8%AD%E5%BA%8F%E4%B8%8E%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91.html
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/27 21:22
 */
public class 路经总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }


        return traverse(root, 0, targetSum);
    }

    /**
     * 体会：回溯时的变量currentSum的维护，可以用递归参数来实现
     * 如 traverse(root.left, currentSum + root.val, targetSum)
     * @param root
     * @param currentSum
     * @param targetSum
     * @return
     */
    private boolean traverse(TreeNode root, int currentSum, int targetSum) {
        if (root.right == null && root.left == null) {
            currentSum += root.val;
            if (currentSum == targetSum) {
                currentSum -= root.val;
                return true;
            }
            return false;
        }

        if (root.left != null) {
            if (traverse(root.left, currentSum + root.val, targetSum)) {
                return true;
            }
        }

        if (root.right != null) {
            if (traverse(root.right, currentSum + root.val, targetSum)) {
                return true;
            }
        }

        return false;
    }
}
