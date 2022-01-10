package carl.二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * https://programmercarl.com/%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%80%92%E5%BD%92%E9%81%8D%E5%8E%86.html
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/8 14:41
 */

public class 中序遍历 {
    List<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
                list.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }

        return list;
    }
}
