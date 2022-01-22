package carl.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 * https://programmercarl.com/0513.%E6%89%BE%E6%A0%91%E5%B7%A6%E4%B8%8B%E8%A7%92%E7%9A%84%E5%80%BC.html
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/22 19:37
 */
public class 找树左下角的值 {
    //递归
    int maxLength = Integer.MIN_VALUE;
    int result = 0;
    public int findBottomLeftValue(TreeNode root) {

        traversal(root, 0);

        return result;
    }

    void traversal(TreeNode root, int curLength) {
        if (root.left == null && root.right == null) {
            if (curLength > maxLength) {
                maxLength = curLength;
                result = root.val;
            }
        }

        if (root.left != null) {
            traversal(root.left, curLength + 1);
        }
        if (root.right != null) {
            traversal(root.right, curLength + 1);
        }
    }

    //迭代
    public int findBottomLeftValue1(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.poll();
                if (i == 0) {
                    result = treeNode.val;
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }

        return result;
    }
}
