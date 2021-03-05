package icu.yezi.leetcode.l树.l合并二叉树;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @PackageName icu.yezi.leetcode.l树.l合并二叉树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/5 星期五 18:39
 */
public class Solution {

    /**
     * 思路分析：
     * A B两棵二叉树同时前序遍历
     *
     * ① A B 其中一个为空，直接返回非空项
     * ② 其他情况，加和赋值给A
     *
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null || root2==null){
            return root1==null? root2 : root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);

        return root1;
    }

}
