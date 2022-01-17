package carl.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://programmercarl.com/0257.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%89%80%E6%9C%89%E8%B7%AF%E5%BE%84.html#%E9%80%92%E5%BD%92
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/17 11:11
 */
public class 二叉树的所有路径 {
    //迭代法
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        stack.push(root.val + "");

        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            //左子节点不为空
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }

        }



        return result;
    }



    //递归法
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        if (root == null) {
            return result;
        }


        traversal(root, result, path);


        return result;
    }

    private void traversal(TreeNode root, List<String> res, List<TreeNode> paths) {
        paths.add(root);
        // 叶子结点
        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i).val).append("->");
            }
            sb.append(paths.get(paths.size() - 1).val);
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, res, paths);
            paths.remove(paths.size() - 1);// 回溯
        }
        if (root.right != null) {
            traversal(root.right, res, paths);
            paths.remove(paths.size() - 1);// 回溯
        }

    }
}
