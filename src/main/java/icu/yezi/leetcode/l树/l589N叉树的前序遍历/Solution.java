package icu.yezi.leetcode.l树.l589N叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.l树.l589N叉树的前序遍历
 * @Data 2020/12/12 星期六 20:03
 */
public class Solution {

    public List<Integer> preorder(Node root) {



        return method2(root);
    }



    /**
     * 套用迭代实现树的前序遍历算法的思想
     * 对二叉树的遍历算法略作修改
     * @param root
     * @return
     */
    public List<Integer> method2(Node root){
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root!=null){
            stack.push(root);
        }

        while (!stack.isEmpty()){
            Node cure = stack.pop();
            list.add(cure.val);

            for (int i = cure.children.size()-1; i >= 0; i--) {
                stack.push(cure.children.get(i));
            }
        }
        return list;
    }
}
