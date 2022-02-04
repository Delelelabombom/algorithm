package carl.二叉树;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * https://programmercarl.com/0700.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E6%90%9C%E7%B4%A2.html#%E9%80%92%E5%BD%92%E6%B3%95
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/2/3 10:39
 */
public class 二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode valNode = searchBST(root.left, val);
        if (valNode == null) {
            valNode = searchBST(root.right, val);
        }
        return valNode;
    }
}
