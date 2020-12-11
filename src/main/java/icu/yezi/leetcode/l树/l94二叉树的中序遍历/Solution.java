package icu.yezi.leetcode.l树.l94二叉树的中序遍历;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.l树.l94二叉树的中序遍历
 * @Data 2020/12/11 星期五 19:37
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){return null;}

        TreeNode cure = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (cure!=null||!stack.isEmpty()){
            while (cure!=null){
                stack.push(cure);
                cure=cure.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            cure=temp.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right=node1;
        node1.left=node2;

        Solution solution = new Solution();
        for (Integer integer : solution.inorderTraversal(root)) {
            System.out.printf("%d ", integer);
        }
    }
}

