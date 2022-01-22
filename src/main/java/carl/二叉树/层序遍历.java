package carl.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://programmercarl.com/0102.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86.html
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/12 15:19
 */
public class 层序遍历 {

    /**
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * 102. 二叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            while (length > 0) {
                TreeNode treeNode = queue.poll();
//                if (treeNode == null) {
//                    list = new ArrayList<>();
//                    treeNode = queue.poll();
//                }
                list.add(treeNode.val);
                length--;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

            result.add(list);

        }

        return result;
    }

    /**
     * https://leetcode-cn.com/problems/binary-tree-right-side-view/
     * 199. 二叉树的右视图
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }


        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            while (length > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                length--;
                if (length == 0) {
                    result.add(treeNode.val);
                }
            }
        }

        return result;
    }

    /**
     * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
     * 637. 二叉树的层平均值
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }


        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            int amount = length;
            long sum = 0;
            while (length > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                sum += treeNode.val;
                length--;
            }
            result.add(sum * 1.0 / amount);
        }

        return result;
    }

    /**
     * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
     * 429. N 叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            while (length > 0) {
                Node node = queue.poll();
                if (node.children != null && node.children.size() != 0) {
                    for (Node child : node.children) {
                        queue.add(child);
                    }
                }
                list.add(node.val);
                length--;
            }
            result.add(list);

        }

        return result;
    }

    // Definition for a Node. 429. N 叉树的层序遍历
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * 104. 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root == null) {
            return depth;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

            }
            depth++;
        }
        return depth;
    }

    /**
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     * 111. 二叉树的最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root == null) {
            return depth;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                if (treeNode.left == null && treeNode.right == null) {
                    return depth + 1;
                }

            }
            depth++;
        }
        return depth;
    }
}

