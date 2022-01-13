package carl.二叉树;

/**
 * https://programmercarl.com/0222.%E5%AE%8C%E5%85%A8%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E8%8A%82%E7%82%B9%E4%B8%AA%E6%95%B0.html
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/13 12:54
 */
public class 完全二叉树节点个数 {
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        int leftDepth = 0;
        TreeNode leftroot = root;
        while (leftroot.left != null) {
            leftroot = leftroot.left;
            leftDepth++;
        }

        int rightDepth = 0;
        TreeNode rightroot = root;
        while (rightroot.right != null) {
            rightroot = rightroot.right;
            rightDepth++;
        }

        if (rightDepth == leftDepth) {
            return (2 << rightDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }
}
