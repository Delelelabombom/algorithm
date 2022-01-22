package carl.二叉树;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * https://programmercarl.com/0404.%E5%B7%A6%E5%8F%B6%E5%AD%90%E4%B9%8B%E5%92%8C.html#%E9%80%92%E5%BD%92%E6%B3%95
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/22 16:48
 */
public class 左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
