package icu.yezi.leetcode.linkedlist.list143;

import java.util.Stack;

/**
 * 需要整理回顾的点：
 *  1. 求链表中点
 *  2. 反转链表
 *
 * @author 叶子
 * @Description 143重排链表  https://leetcode-cn.com/problems/reorder-list/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.linkedlist.list143
 * @Data 2020/12/8 星期二 18:20
 */
public class Main {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        ListNode tail = head;
        for (int i = 2; i < 5; i++) {
            ListNode temp = new ListNode(i);
            tail.next = temp;
            tail = temp;
        }

        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        method3(head);
    }

    /**
     * 解法一：
     *      将链表结点保存在一个栈中，再遍历链表进行插入
     * 开辟了不必要的空间
     * @param head
     */
    public static void method1(ListNode head){
        if (head == null ){
            return;
        }
        if (head.next == null){
            return;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode cure = head;
        while (cure != null){
            stack.push(cure);
            cure = cure.next;
        }
        int size = stack.size();
        int count = size%2==0? size/2-1:size/2;

        cure = head;
        for (int i = 0; i < count; i++) {
            ListNode next = cure.next;
            ListNode insert = stack.pop();

            cure.next = insert;
            insert.next = next;
            cure = next;
        }
        if (size%2==0){
            cure.next.next = null;
        }else {
            cure.next = null;
        }
    }

    /**
     * 解法二：
     *      寻找链表中点，将右侧链表压入栈
     *      遍历中点左侧链表，插入结点
     * 减少了一般的空间开销
     * @param head
     */
    public static void method2(ListNode head){
        if (head == null ){
            return;
        }
        if (head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode middle = slow;
        while (slow.next != null){
            slow = slow.next;
            stack.push(slow);
        }

        ListNode cure = head;
        while (!stack.isEmpty()){
            ListNode insert = stack.pop();
            ListNode next = cure.next;

            cure.next = insert;
            insert.next =next;
            cure = next;
        }
        if (fast == null){
            middle.next = null;
        }else {
            middle.next.next =null;
        }
    }

    /**
     *
     * 解法三：（官方）
     *      寻找链表中点，将右侧链表反转
     *      合并左右两条链表
     */

    public static void method3(ListNode head){
        if (head == null){
            return;
        }
        if (head.next == null){
            return;
        }
        ListNode mid = getMid(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;

        rightHead = reserve(rightHead);
        merge(leftHead,rightHead);
    }

    /**
     * 获取链表中点（快慢指针法）
     * @param head
     * @return
     */
    public static ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 反转链表（双指针法）
     * @param head
     */
    public static ListNode reserve(ListNode head){
        ListNode pre = null;
        ListNode cure = head;

        while (cure != null){
            ListNode next = cure.next;
            cure.next = pre;

            pre = cure;
            cure = next;
        }
        return pre;
    }

    /**
     * 合并链表，特殊情况
     * l1.size - l2.size = 1
     * @param l1
     * @param l2
     */
    public static void merge(ListNode l1,ListNode l2){
        ListNode l1next = null;
        ListNode l2next = null;

        while (l1!=null && l2!=null){
            l1next = l1.next;
            l2next = l2.next;

            l1.next = l2;
            l1 = l1next;

            l2.next = l1;
            l2 = l2next;
        }
    }
}

