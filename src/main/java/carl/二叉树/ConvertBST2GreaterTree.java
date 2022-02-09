package carl.二叉树;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * https://programmercarl.com/0538.%E6%8A%8A%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E8%BD%AC%E6%8D%A2%E4%B8%BA%E7%B4%AF%E5%8A%A0%E6%A0%91.html#%E9%80%92%E5%BD%92
 * @author LiPeishu
 * @version 1.0
 * @description:
 * 中序遍历！
 * 反中序遍历
 * @date 2022/2/8 22:15
 */
public class ConvertBST2GreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);

        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }


}
