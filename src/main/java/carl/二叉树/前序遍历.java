package carl.二叉树;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://programmercarl.com/%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%80%92%E5%BD%92%E9%81%8D%E5%8E%86.html
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/8 14:32
 */

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class 前序遍历 {
    List<Integer> list = new LinkedList<>();
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            list.add(currentNode.val);
            if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                currentNode = stack.pop();
            }
        }

        return list;
    }
}
