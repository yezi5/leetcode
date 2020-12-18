package icu.yezi.leetcode.l树.N叉树后序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * @PackageName icu.yezi.leetcode.l树.N叉树后序遍历
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/18 星期五 10:55
 */
public class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        if (root!=null){
            list.add(root.val);
        }
        return list;
    }

    /**
     * 递归实现
     * @param node
     * @param list
     */
    private void traverse(Node node, List<Integer> list) {
        if (node==null){return;}
        for (Node child : node.children) {
            traverse(child,list);
            list.add(child.val);
        }
    }



}


