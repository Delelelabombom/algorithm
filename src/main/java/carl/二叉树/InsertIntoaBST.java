package carl.二叉树;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * https://programmercarl.com/0701.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E6%8F%92%E5%85%A5%E6%93%8D%E4%BD%9C.html#%E9%80%92%E5%BD%92
 * @author LiPeishu
 * @version 1.0
 * @description:
 * @date 2022/2/6 21:56
 */
public class InsertIntoaBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            traverse(root, val);
        }
        return root;
    }

    private void traverse(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            traverse(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            traverse(root.right, val);
        }
    }
}
