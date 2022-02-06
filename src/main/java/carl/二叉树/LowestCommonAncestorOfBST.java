package carl.二叉树;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * https://programmercarl.com/0235.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html#%E9%80%92%E5%BD%92%E6%B3%95
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/2/6 21:07
 */
public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return traverse(root, p, q);
        } else {
            return traverse(root, q, p);
        }
    }

    private TreeNode traverse(TreeNode root, TreeNode larger, TreeNode smaller) {
//        if (root == null) {
//            return root;
//        }

        if (root.val > larger.val) {
            TreeNode left = traverse(root.left, larger, smaller);
            return left;
        }else if (root.val < smaller.val) {
            TreeNode right = traverse(root.right, larger, smaller);
            return right;
        }else {
//            traverse(root.left, larger, smaller);
//            traverse(root.right, larger, smaller);
            return root;
        }
    }
}
