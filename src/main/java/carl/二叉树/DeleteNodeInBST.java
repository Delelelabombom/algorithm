package carl.二叉树;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * https://programmercarl.com/0450.%E5%88%A0%E9%99%A4%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E8%8A%82%E7%82%B9.html#%E9%80%92%E5%BD%92
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/2/8 9:17
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            //三种情况： root无孩子， root有一个孩子， root有两个孩子
            if (root.left != null && root.right != null) {
                TreeNode leftChild = root.left;
                root = root.right;
                TreeNode currentNode = root;
                while (currentNode.left != null) {
                    currentNode = currentNode.left;
                }
                currentNode.left = leftChild;
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                //无孩子
                root = null;
            }
            return root;
        } else if (root.val < key){
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

}
