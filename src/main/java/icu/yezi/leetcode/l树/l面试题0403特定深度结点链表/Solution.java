package icu.yezi.leetcode.l树.l面试题0403特定深度结点链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/list-of-depth-lcci/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.l树.l面试题0403特定深度结点链表
 * @Data 2020/12/15 星期二 19:10
 */
public class Solution {

    /**
     * 得益于之前刚好做过一道特殊的层序遍历的问题————从上到下打印二叉树Ⅱ
     * 该题要求把二叉树每层的数据放在一个新创建的数组中，最后返回的数组中存放着放每层数据的数组
     * 该题的特点在于：
     *      要精确分别层与层间的界限
     *
     * 该题的思路恰好可用于此题
     * 基本思路：
     *  套用之前的算法，获取每层数据，然后创建链表进行保存
     *
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        // 保存返回的链表头信息
        List<ListNode> listNodes = new ArrayList<>();
        if (tree!=null){
            queue.add(tree);
        }

        while (!queue.isEmpty()){

            int size = queue.size();
            // 链表头尾结点
            ListNode root = null;
            ListNode tail = null;
            // 遍历每层数据，注意i这个巧妙地初始化
            for (int i = size; i > 0; i--) {
                TreeNode cure = queue.poll();
                if (i==size){   //初始化链表头和链表尾
                    root = new ListNode(cure.val);
                    tail = root;
                }else { //构建链表
                    ListNode listNode = new ListNode(cure.val);
                    tail.next = listNode;
                    tail = listNode;
                }
                // 更新队列
                if (cure.left!=null){
                    queue.add(cure.left);
                }
                if (cure.right!=null){
                    queue.add(cure.right);
                }
            }
            tail.next = null;
            // 保存链表头信息，这个动作也可以放在链表初始化处
            listNodes.add(root);
        }

        return listNodes.toArray(new ListNode[listNodes.size()]);
    }
}
