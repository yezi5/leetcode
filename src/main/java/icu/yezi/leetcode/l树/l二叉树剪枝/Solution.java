package icu.yezi.leetcode.l树.l二叉树剪枝;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/binary-tree-pruning/
 * @PackageName icu.yezi.leetcode.l树.l二叉树剪枝
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/6 星期六 10:40
 */
public class Solution {

    public TreeNode pruneTree(TreeNode root) {
        return method1(root);
    }

    private TreeNode method1(TreeNode root) {
        if (root == null) return null;
        if (root.val == 1) return root;

        TreeNode left = method1(root.left);
        TreeNode right = method1(root.right);

        if (left == null){
            root.left = null;
        }
        if (right == null){
            root.right = null;
        }

        return (left==null && right==null)?null:root;
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
