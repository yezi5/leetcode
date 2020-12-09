package icu.yezi.leetcode.linkedlist.list82;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 叶子
 * @Description 82. 删除排序链表中的重复元素 II https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.linkedlist.list82
 * @Data 2020/12/9 星期三 11:07
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        ListNode head = new ListNode(1);
        ListNode tail = head;

        for (int i = 0; i < 2; i++) {
            ListNode node = new ListNode(1);
            tail.next = node;
            tail = node;
        }

        for (int i = 0; i < 2; i++) {
            ListNode node = new ListNode(2);
            tail.next = node;
            tail = node;
        }
        tail.next = null;

        main.deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        return method2(head);
    }

    /**
     * 解法一：
     *  由于是排序链表，所以重复的数肯定相邻，因此可以暴力循环
     *  遇到相同数时循环丢掉所有相同数
     *  时间复杂度 O(n)
     * @param head
     * @return
     */
    public ListNode method1(ListNode head){
        if (head==null||head.next==null){return head;}
        // 前置结点
        ListNode pre = new ListNode(0);
        pre.next = head;

        /**
         * 用来记录新链表头结点的前置结点
         *
         * 我们分两种情况来讨论：
         *  1. 原链表头结点无重复，如 1 2 3
         *      此时，pre初始为head的前置结点，那么preHead.next就是head
         *  2. 原链表头结点重复，如 1 1 2
         *      此时，1 1 删除后，pre的next域指向 2，2就是新的头结点
         *      那么，此时preHead的next域指向的仍然是头结点（pre之后的后移不影响preHead）
         */
        ListNode preHead = pre;

        ListNode cure = head;
        while (cure!=null && cure.next!=null){
            boolean flag = false;
            //丢弃重复结点
            while (cure.val == cure.next.val){
                flag = true;
                cure = cure.next;
                if (cure==null || cure.next==null){
                    break;
                }
            }

            cure = cure.next;
            if (flag){
                pre.next = cure;
            }else {
                pre = pre.next;
            }
        }
        return preHead.next;
    }

    /**
     * 方法二：map
     * @param head
     * @return
     */
    public ListNode method2(ListNode head){

        return null;
    }
}
