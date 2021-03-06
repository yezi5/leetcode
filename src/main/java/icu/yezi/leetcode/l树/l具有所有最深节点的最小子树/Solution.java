package icu.yezi.leetcode.l树.l具有所有最深节点的最小子树;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 * @PackageName icu.yezi.leetcode.l树.l具有所有最深节点的最小子树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/6 星期六 10:11
 */
public class Solution {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {



        return method1(root);
    }

    /**
     * 关键：观察目标结点的特点
     *
     * 左右子树深度一致
     *
     * @param root
     * @return
     */
    public TreeNode method1(TreeNode root){
        if (root == null) return root;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right){
            return root;
        }else if (left > right){
            return method1(root.left);
        }else {
            return method1(root.right);
        }
    }

    public int depth(TreeNode root){
        if (root == null) return 0;

        return Math.max(depth(root.left),depth(root.right)) + 1;
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
