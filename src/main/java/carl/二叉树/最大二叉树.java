package carl.二叉树;

/**
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/2/2 21:11
 */
public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = MaximumBinaryTree(nums, 0, nums.length);
        return root;
    }

    private TreeNode MaximumBinaryTree(int[] nums, int lo, int hi) {
        if (hi == lo) {
            return null;
        }
        if (hi - lo == 1) {
            return new TreeNode(nums[lo]);
        }

        int rootIndex = getMaxIndex(nums, lo, hi);
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = MaximumBinaryTree(nums, lo, rootIndex);
        root.right = MaximumBinaryTree(nums, rootIndex, hi);
        return root;
    }

    /**
     *
     * @param nums
     * @param lo inclusive
     * @param hi exclusive
     * @return
     */
    private int getMaxIndex(int[] nums, int lo, int hi) {
        int result = Integer.MIN_VALUE;
        int index = -1;
        for (int i = lo; i < hi; i++) {
            if (nums[i] > result) {
                result = nums[i];
                index = i;
            }
        }
        return index;
    }
}
