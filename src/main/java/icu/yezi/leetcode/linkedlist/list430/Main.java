package icu.yezi.leetcode.linkedlist.list430;

/**
 * @author 叶子
 * @Description 扁平化多级双向链表  https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.linkedlist.list430
 * @Data 2020/12/8 星期二 21:38
 */
public class Main {

    public static void main(String[] args) {

    }


    public Node flatten(Node head) {
        Node cure = head;
        while (cure != null) {
            if (cure.child != null) {
                Node next = cure.next;
                Node child = cure.child;
                cure.next = child;
                cure.child = null;

                child.prev = cure;
                while (child.next != null)
                    child = child.next;
                child.next = next;

                if (next != null)
                    next.prev = child;
            }
            cure = cure.next;
        }
        return head;
    }
}
