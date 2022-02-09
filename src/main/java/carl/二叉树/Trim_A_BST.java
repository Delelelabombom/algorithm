package carl.二叉树;

import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 * https://programmercarl.com/0669.%E4%BF%AE%E5%89%AA%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html
 * @author LiPeishu
 * @version 1.0
 * @description:
 * @date 2022/2/8 17:50
 */
public class Trim_A_BST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
//        while (root.val > high || root.val < low) {
//            if (root.val > high) {
//                root = root.left;
//                if (root == null) {
//                    return null;
//                }
//            }
//            if (root.val < low) {
//                root = root.right;
//                if (root == null) {
//                    return null;
//                }
//            }
//        }


        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }


}
