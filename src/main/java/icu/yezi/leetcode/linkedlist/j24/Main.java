package icu.yezi.leetcode.linkedlist.j24;

/**
 * @author 叶子
 * @Description 剑指 Offer 24. 反转链表 https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.linkedlist.j24
 * @Data 2020/12/9 星期三 10:12
 */
public class Main {

    public ListNode reverseList(ListNode head) {
        return method1(head);
    }

    /**
     * 双指针法
     *
     * 时间复杂度 O(n)
     * @param head
     * @return
     */
    public ListNode method1(ListNode head){
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
     * 妖魔化的双指针
     * cure初始为head
     * 改变head的next域
     * 每次使head.next的next指向cure
     *
     * 令cure和head的next域后移
     * @param head
     * @return
     */
    public ListNode method2(ListNode head){
        ListNode cure = head;

        while (head.next != null){
            head.next.next = cure;
            cure = head.next;
            head.next = cure.next;
        }
        return cure;
    }
}

