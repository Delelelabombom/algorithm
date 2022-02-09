package carl.二叉树;

import javax.swing.tree.TreePath;
import java.util.TreeMap;

/**
 * @author LiPeishu
 * @version 1.0
 * @description:
 * @date 2022/2/8 21:20
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traverse(nums, 0, nums.length);


    }

    /**
     * 区间左闭右开
     * @param nums
     * @param lo inclusive
     * @param hi exclusive
     * @return
     */
    private TreeNode traverse(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return null;
        }
        int length = (hi - lo) / 2;
        TreeNode treeNode = new TreeNode(nums[length + lo]);
        treeNode.left = traverse(nums, lo, lo + length);
        treeNode.right = traverse(nums, lo + length + 1, hi);
        return treeNode;
    }
}
