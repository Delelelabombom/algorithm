package carl.二叉树;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * https://programmercarl.com/0110.%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91.html
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/13 13:06
 */
public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isBalanced(root.left)) {
            if (isBalanced(root.right)) {
                int leftHeight = getHeight(root.left);
                int rightHeight = getHeight(root.right);
                return Math.abs(leftHeight - rightHeight) <= 1;
            }
        }
        return false;
    }

    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(getHeight(treeNode.left), getHeight(treeNode.right)) + 1;
    }
}
