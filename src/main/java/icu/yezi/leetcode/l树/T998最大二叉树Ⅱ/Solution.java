package icu.yezi.leetcode.l树.T998最大二叉树Ⅱ;

/**
 * 关于题目的分析：
 *  以递归的思想分析，
 *      1. val成为子树根结点的父结点，子树根结点是val的左子结点（子树根结点可以为空结点）
 *      2. 如果val存在父结点，那么他一定是父结点的右子结点
 *
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/maximum-binary-tree-ii/
 * @PackageName icu.yezi.leetcode.l树.T998最大二叉树Ⅱ
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/18 星期五 13:39
 */
public class Solution {

    /**
     * 极限递归
     *
     * 深入理解
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root==null || root.val<val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        root.right = insertIntoMaxTree(root.right,val);

        return root;
    }
}

