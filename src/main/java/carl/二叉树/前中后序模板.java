package carl.二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/12 14:01
 */
public class 前中后序模板 {
    /**
     * 中序遍历模板
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.peek();
            if (treeNode != null) {
                stack.pop();
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
                stack.push(treeNode);
                stack.push(null);
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }
            }else {
                stack.pop();
                result.add(stack.pop().val);
            }
        }


        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.peek();
            if (treeNode != null) {
                stack.pop();
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }
                stack.push(treeNode);
                stack.push(null);
            }else {
                stack.pop();
                result.add(stack.pop().val);
            }
        }


        return result;
    }

    /**
     * 后序
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.peek();
            if (treeNode != null) {
//                stack.pop();
//                stack.push(treeNode);
                stack.push(null);
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }

            }else {
                stack.pop();
                result.add(stack.pop().val);
            }
        }


        return result;
    }
}
