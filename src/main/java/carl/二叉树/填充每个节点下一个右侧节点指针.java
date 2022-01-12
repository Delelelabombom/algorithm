package carl.二叉树;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2022/1/12 17:25
 */
public class 填充每个节点下一个右侧节点指针 {

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        if (root == null) {
            return null;
        }

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node node = queue.poll();
                if (i != length - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }


        return root;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

