package icu.yezi.leetcode.linkedlist.j18;

/**
 * @author 叶子
 * @Description 剑指offer18 删除链表的节点  https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.linkedlist.j18
 * @Data 2020/12/9 星期三 16:55
 */
public class Main {

    public ListNode deleteNode(ListNode head, int val) {
        if (head==null){
            return null;
        }
        if (head.val == val){
            return head.next;
        }
        ListNode pre = head;

        while (pre.next!=null&&pre.next.val!=val){pre = pre.next;}
        pre.next = pre.next.next;

        return head;
    }
}

