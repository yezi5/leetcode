package icu.yezi.leetcode.l树.l平衡二叉树判断;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @PackageName icu.yezi.leetcode.l树.l平衡二叉树判断
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/2 星期二 19:51
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;

        return (Math.abs(depth(root.left) - depth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left),depth(root.right));
    }
}
