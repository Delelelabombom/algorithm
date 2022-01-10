package carl.二叉树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * https://programmercarl.com/%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%80%92%E5%BD%92%E9%81%8D%E5%8E%86.html
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/8 14:44
 */
public class 后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            list.add(currentNode.val);
            stack.push(currentNode.left);
            stack.push(currentNode.right);
        }
        Collections.reverse(list);

        return list;
    }
}
