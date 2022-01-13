package carl.二叉树;

import java.util.*;

/**
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/13 11:17
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return true;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.poll();
                list.add(null);
                if (treeNode != null) {
                    list.remove(list.size() - 1);
                    list.add(treeNode.val);
                    queue.add(treeNode.left);
                    queue.add(treeNode.right);
                }
             }
            int i = 0;
            int j = list.size() - 1;
            while (i < j) {
                if (!Objects.equals(list.get(i), list.get(j))) {
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }
}
