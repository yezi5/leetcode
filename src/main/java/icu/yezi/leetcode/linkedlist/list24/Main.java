package icu.yezi.leetcode.linkedlist.list24;

/**
 * 思路：
 * 原本两点交换是要以两点中的第一个点为当前结点进行交换（比如值的交换）
 * 但是，这个题要求结点地址的交换，因此不能这样做
 *
 * 原因：
 *  未交换前： ① --> ② --> ③ --> ④
 *  交换后：   ① --> ②    ④ --> ③
 *  注意：
 *      此时，虽然 ③ 和 ④ 完成了交换，但是 ② 仍然指向 ③
 *      这就造成了链表的截断
 *  按照只关注两个点的思维交换，就会出现这种错误
 *  所以，我们要关注三个点：两个交换点+交换点的前一个点
 *
 *  以交换点前的点作为当前结点
 *      在完成两点交换的同时，改变前点的next域
 *
 *  具体步骤：
 *      1. 创建哑结点 dumbNode ，next域指向head
 *      2. 创建temp结点作为循环时的当前结点，初始为 dumbNode
 *      3. 当temp.next temp.next.next 均不为 null时进入下一轮循环
 *      先获取temp后两个节点
 *      node1 = temp.next
 *      node2 = temp.next.next
 *
 *      完成 temp 后两结点交换的操作
 *      node1.next = node2.next
 *      node2.next = node1
 *
 *      此时 node2 --> node1 但是 temp --> node1
 *      改变temp的next域
 *      temp.next = node2
 *      最后，让temp前进，进入下一轮循环
 *      temp = node1 （注意，是node1，因为 temp --> node2 --> node1，node1和node2交换过了）
 *
 * @author 叶子
 * @Description 两两交换链表中结点  https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.linkedlist.list24
 * @Data 2020/12/8 星期二 21:34
 */
public class Main {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dumbNode = new ListNode();

        dumbNode.next = head;
        ListNode temp = dumbNode;

        while (temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            temp = node1;
        }



        return dumbNode.next;
    }
}
