package carl.LIST;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/design-linked-list/
 *https://programmercarl.com/0707.%E8%AE%BE%E8%AE%A1%E9%93%BE%E8%A1%A8.html#%E4%BB%A3%E7%A0%81
 *
 *
 * @author LiPeishu
 * @version 1.0
 * @description: TODO
 * @date 2021/12/13 11:52
 */
public class MyLinkedList {
    int length;
    ListNode listNode;

    public MyLinkedList() {
        length = 0;
        listNode = new ListNode();
    }

    public int get(int index) {
        if (index > length - 1) {
            return -1;
        }
        ListNode node = listNode.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        ListNode listNode1 = new ListNode(val);
        ListNode oldHeader = listNode.next;
        listNode.next = listNode1;
        listNode1.next = oldHeader;
        length++;
    }

    public void addAtTail(int val) {
        if (length == 0) {
            addAtHead(val);
            return;
        }
        ListNode node = listNode.next;
        for (int i = 0; i < length - 1; i++) {
            node = node.next;
        }
        node.next = new ListNode(val);
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index > length) {
            return;
        }
        ListNode node = listNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        ListNode oldIndexNode = node.next;
        node.next  = new ListNode(val);
        node.next.next = oldIndexNode;
        length++;
    }

    public void deleteAtIndex(int index) {
        if (0 <= index && index <= length - 1) {
            ListNode node = listNode;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            ListNode newIndexNode = node.next.next;
            node.next = newIndexNode;
            length--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3


    }


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(){}
//    ListNode(int val) {
//        this.val=val;
//    }
//}

