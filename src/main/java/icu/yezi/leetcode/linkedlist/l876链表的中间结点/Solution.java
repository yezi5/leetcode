package icu.yezi.leetcode.linkedlist.l876链表的中间结点;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.linkedlist.l876链表的中间结点
 * @Data 2020/12/12 星期六 18:45
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        /**
         * 这里需要注意fast的起点
         *
         * 如果题目要求返回两个中点的第一个，那么 fast=head.next
         */
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
}

