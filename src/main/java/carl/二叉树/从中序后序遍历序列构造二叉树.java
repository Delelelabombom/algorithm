package carl.二叉树;

import java.util.Arrays;

/**
 * https://programmercarl.com/0106.%E4%BB%8E%E4%B8%AD%E5%BA%8F%E4%B8%8E%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E6%80%9D%E8%B7%AF
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/2/2 20:08
 */
public class 从中序后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        if (inorder.length == 0) {
            return null;
        }
        int rootValue = postorder[postorder.length - 1];
        int inorderIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                inorderIndex = i;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, inorderIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, inorderIndex + 1, inorder.length);

        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, inorderLeft.length);
        int[] postorderRight = Arrays.copyOfRange(postorder, inorderLeft.length, postorder.length - 1);
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);

        return root;
    }


}
