package carl.二叉树;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * https://programmercarl.com/0501.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E4%BC%97%E6%95%B0.html#%E9%80%92%E5%BD%92%E6%B3%95
 *
 * @author LiPeishu
 * @version 1.0
 * @description: 501
 * @date 2022/2/4 13:45
 */
public class FindModeInBST {
    ArrayList<Integer> results = new ArrayList<>();
    TreeNode prevNode = null;
    int maxCount = 0;
    int counts = 0;
    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] res = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            res[i] = results.get(i);
        }
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        if (prevNode == null || prevNode.val != root.val) {
            prevNode = root;
            counts = 1;

        } else {
            counts++;
        }
        if (counts > maxCount) {
            results.clear();
            results.add(root.val);
            maxCount = counts;
        } else if (counts == maxCount) {
            results.add(root.val);
        }


        traverse(root.right);
    }
}
