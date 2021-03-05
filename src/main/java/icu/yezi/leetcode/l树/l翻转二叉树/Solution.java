package icu.yezi.leetcode.l树.l翻转二叉树;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.l树.l翻转二叉树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/5 星期五 19:25
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        traverse(root);

        return root;
    }

    void traverse(TreeNode root){
        if (root==null) return;
        TreeNode cure = root.left;
        root.left = root.right;
        root.right = cure;

        traverse(root.left);
        traverse(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
