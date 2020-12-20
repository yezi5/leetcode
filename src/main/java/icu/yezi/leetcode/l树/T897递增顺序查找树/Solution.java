package icu.yezi.leetcode.l树.T897递增顺序查找树;

import java.util.Stack;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.l树.T897递增顺序查找树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/18 星期五 15:56
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.increasingBST(init());
    }

    public static TreeNode init(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;
        node6.right = node8;
        node8.left = node7;
        node8.right = node9;

        return node5;
    }

    public TreeNode increasingBST(TreeNode root) {
        return test1(root);
    }

    private TreeNode test1(TreeNode root) {
        TreeNode preRoot = new TreeNode();
        TreeNode temp = preRoot;
        TreeNode cure = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cure!=null || !stack.isEmpty()){
            while (cure!=null){
                stack.push(cure);
                cure = cure.left;
            }
            cure = stack.pop();
            temp.right = new TreeNode(cure.val);
            temp=temp.right;
            cure = cure.right;
        }
        return preRoot.right;
    }


}

