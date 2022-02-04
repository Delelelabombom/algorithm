package carl.二叉树;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * https://programmercarl.com/0617.%E5%90%88%E5%B9%B6%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E9%80%92%E5%BD%92
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/2/3 10:30
 */
public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
