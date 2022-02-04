package carl.二叉树;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * https://programmercarl.com/0106.%E4%BB%8E%E4%B8%AD%E5%BA%8F%E4%B8%8E%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E6%80%9D%E8%B7%AF
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/2/2 20:53
 */
public class 从前序中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        int inorderIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                inorderIndex = i;
                break;
            }
        }
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, inorderIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, inorderIndex + 1, inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, inorderLeft.length + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, inorderLeft.length + 1, preorder.length);

        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root;
    }
}
