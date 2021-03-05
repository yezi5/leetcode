package icu.yezi.leetcode.l树.l合并二叉树;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.l树.l合并二叉树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/5 星期五 18:38
 */
public class TreeNode {
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
