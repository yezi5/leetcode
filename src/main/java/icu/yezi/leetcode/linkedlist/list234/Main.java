package icu.yezi.leetcode.linkedlist.list234;


import java.util.Stack;

/**
 * 这个题目的基本思路就是倒序匹配，但实现方式有很多种。
 * 两种实现思路，四种实现办法
 * 第四种是最佳的，在空间和和时间上都更占优势
 * 第一种：全部倒序，然后和原链表匹配
 *      1. 复制原链表，再将复制链表反转，和原链表进行匹配
 *      2. 使用栈保存链表，再和原链表进行匹配
 * 第二种：中点倒序，然后链表的前段和后段进行匹配
 *      1. 使用栈保存中点右侧链表，然后和中点左侧链表进行匹配
 *      2. 反转中点右侧链表，和左侧链表进行匹配
 *
 * @author 叶子
 * @Description 234回文链表 https://leetcode-cn.com/problems/palindrome-linked-list/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.linkedlist.list234
 * @Data 2020/12/9 星期三 15:12
 */
public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = head;

        for (int i = 2; i < 4; i++) {
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = node;
        }
        for (int i = 3; i > 0; i--) {
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = node;
        }
        tail.next = null;

        new Main().isPalindrome(head);

    }

    public boolean isPalindrome(ListNode head){
        return method1(head);
    }

    public boolean method1(ListNode head){
        if(head==null || head.next==null){return true;}
        ListNode newHead = new ListNode(head.val);
        ListNode tail = newHead;

        ListNode cure = head.next;
        while (cure != null){
            ListNode node = new ListNode(cure.val);
            tail.next = node;
            tail = node;
            cure = cure.next;
        }
        tail.next = null;

        head = reserveList(head);

        while (newHead!=null&&head!=null){
            if (newHead.val!=head.val){
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    public boolean method2(ListNode head){
        if(head==null || head.next==null){return true;}
        Stack<ListNode> stack = new Stack<>();

        ListNode cure = head;
        while (cure != null){
            stack.push(cure);
            cure=cure.next;
        }
        cure = head;
        while (cure != null){
            if (cure.val != stack.pop().val){
                return false;
            }
            cure=cure.next;
        }
        return true;
    }

    public boolean method3(ListNode head){
        if(head==null || head.next==null){return true;}
        ListNode mid = getMid(head);
        Stack<ListNode> stack = new Stack<>();
        ListNode cure = mid;
        while (cure!=null){
            stack.push(cure);
            cure = cure.next;
        }

        while (head!=mid){
            if (head.val!=stack.pop().val){
                return false;
            }
            head=head.next;
        }

        return true;
    }

    /**
     * 解法四：寻找中点，反转链表
     *  1. 找到链表中点，将右侧链表反转
     *  2. 原链表和反转链表进行比对，不一致就返回false（只比对中点之前的）
     *
     *  这里的中点有点特别：
     *      1 2 1 取2
     *      1 2 2 1 取第二个2
     *
     * @param head
     * @return
     */
    public boolean method4(ListNode head){
        if(head==null || head.next==null){return true;}
        ListNode mid = getMid(head);

        ListNode rightHead = reserveList(mid);

        while (head!=mid&&rightHead!=null){
            if (head.val != rightHead.val){
                return false;
            }
            head=head.next;
            rightHead=rightHead.next;
        }

        return true;
    }

    /**
     * 快慢指针法获取链表中点
     * @param head
     * @return
     */
    public static ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 双指针迭代反转链表
     * @param head
     * @return
     */
    public static ListNode reserveList(ListNode head){
        ListNode pre = null;
        ListNode cure = head;

        while (cure!=null){
            ListNode next = cure.next;
            cure.next = pre;
            pre = cure;
            cure = next;
        }

        return pre;
    }
}
