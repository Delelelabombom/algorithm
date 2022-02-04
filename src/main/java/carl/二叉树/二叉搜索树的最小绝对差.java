package carl.二叉树;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * https://programmercarl.com/0530.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E5%B0%8F%E7%BB%9D%E5%AF%B9%E5%B7%AE.html#%E9%80%92%E5%BD%92
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/2/3 15:06
 */
public class 二叉搜索树的最小绝对差 {
    public int getMinimumDifference(TreeNode root) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        traverse(root, linkedList);
        int currentMinimum = Integer.MAX_VALUE;
        while (linkedList.size() > 1) {
            currentMinimum = Integer.min(currentMinimum, linkedList.removeLast() - linkedList.getLast());
        }
        return currentMinimum;
    }

    private void traverse(TreeNode root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}
