package carl.二叉树;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * https://programmercarl.com/0236.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html#java
 * @author LiPeishu
 * @version 1.0
 * @description:
 * @date 2022/2/4 18:50
 */
public class LowestCommonAncestorOfaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode pq1 = lowestCommonAncestor(root.left, p, q);
        TreeNode pq2 = lowestCommonAncestor(root.right, p, q);
        if (pq1 != null && pq2 != null) {
            return root;
        } else if (pq1 != null) {
            return pq1;
        } else if (pq2 != null) {
            return pq2;
        }

        return null;
    }

//    private boolean traverse(TreeNode treeNode, TreeNode q) {
//        if (treeNode == null) {
//            return false;
//        }
//
//        if (traverse(treeNode.left, q))
//        if (treeNode.val == q.val) {
//
//        }
//
//        traverse(treeNode.right, q);
//    }
}
