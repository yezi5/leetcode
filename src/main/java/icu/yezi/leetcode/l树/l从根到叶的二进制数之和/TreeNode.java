package icu.yezi.leetcode.l树.l从根到叶的二进制数之和;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 * @PackageName icu.yezi.leetcode.l树.l从根到叶的二进制数之和
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/4 星期四 15:16
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
