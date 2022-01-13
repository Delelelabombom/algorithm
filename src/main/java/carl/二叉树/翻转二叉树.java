package carl.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://programmercarl.com/0226.%E7%BF%BB%E8%BD%AC%E4%BA%8C%E5%8F%89%E6%A0%91.html
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/12 17:59
 */
public class 翻转二叉树 {
    //层次遍历
    public TreeNode invertTree3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return root;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.poll();

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

                TreeNode temp = treeNode.left;
                treeNode.left = treeNode.right;
                treeNode.right = temp;

            }
        }
        return root;
    }

    //前序遍历
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return root;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode != null) {
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }
                stack.push(treeNode);
                stack.push(null);

            }else {
                TreeNode currentNode  = stack.pop();
                TreeNode tmp = currentNode.left;
                currentNode.left = currentNode.right;
                currentNode.right = tmp;
            }
        }

        return root;
    }
}
