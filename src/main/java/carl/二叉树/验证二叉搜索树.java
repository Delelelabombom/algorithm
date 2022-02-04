package carl.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * https://programmercarl.com/0098.%E9%AA%8C%E8%AF%81%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html#%E9%80%92%E5%BD%92%E6%B3%95
 * @author LiPeishu
 * @version 1.0
 * @description: 中序遍历
 * @date 2022/2/3 10:46
 */
public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        LinkedList<Integer> bsts = new LinkedList<>();

//        int bstsLast = bsts.removeLast();
//        while (!bsts.isEmpty()) {
//            if (bsts.getLast() >= bstsLast) {
//                return false;
//            }
//            bstsLast = bsts.removeLast();
//        }
        return traverse(root, bsts);
    }

    private boolean traverse(TreeNode root, LinkedList<Integer> bsts) {
        if (root == null) {
            return true;
        }
        if (traverse(root.left, bsts) == false) {
            return false;
        }
        if (!bsts.isEmpty() && bsts.getLast() >= root.val) {
            return false;
        }
        bsts.add(root.val);
        if (traverse(root.right, bsts) == false) {
            return false;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        //LinkedList<Integer> bsts = new LinkedList<>();
        boolean previousElementFlag = false;
        int previousElement = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode != null) {
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
                stack.push(treeNode);
                stack.push(null);
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }
            } else {
                if (previousElementFlag == false) {
                    previousElementFlag = true;
                } else {
                    if (stack.peek().val <= previousElement) {
                        return false;
                    }
                }
                previousElement = stack.pop().val;


                //bsts.add(stack.pop().val);
            }
        }
//        int bstsLast = bsts.removeLast();
//        while (!bsts.isEmpty()) {
//            if (bsts.getLast() >= bstsLast) {
//                return false;
//            }
//            bstsLast = bsts.removeLast();
//        }

        return true;
    }
}
