package icu.yezi.leetcode.linkedlist.list21;

/**
 * @author 叶子
 * @Description 合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.linkedlist.list21
 * @Data 2020/12/8 星期二 21:42
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * 解法一：笨方法
     *  构建新链表
     *  一次遍历，比较两链表，小的结点先添加
     *
     * 解法二：
     *  递归（这种方法也适用于两个无序链表的合并）
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cure = head;

        ListNode cureOne = l1;
        ListNode cureTwo = l2;

        while (cureOne != null || cureTwo != null){
            ListNode node = null;
            if (cureOne == null){
                node = new ListNode(cureTwo.val);
                cure.next = node;
                cure = node;
                cureTwo = cureTwo.next;
                continue;
            }
            if (cureTwo == null){
                node = new ListNode(cureOne.val);
                cure.next = node;
                cure = node;
                cureOne = cureOne.next;
                continue;
            }

            if (cureOne.val > cureTwo.val){
                node = new ListNode(cureTwo.val);
                cure.next = node;
                cure = node;
                cureTwo = cureTwo.next;
            }else {
                node = new ListNode(cureOne.val);
                cure.next = node;
                cure = node;
                cureOne = cureOne.next;
            }
        }

        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
}
