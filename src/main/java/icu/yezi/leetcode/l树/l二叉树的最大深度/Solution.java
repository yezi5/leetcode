package icu.yezi.leetcode.l树.l二叉树的最大深度;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.l树.l二叉树的最大深度
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/5 星期五 19:42
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
