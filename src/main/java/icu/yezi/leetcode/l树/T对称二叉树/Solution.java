package icu.yezi.leetcode.l树.T对称二叉树;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @PackageName icu.yezi.leetcode.l树.T对称二叉树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/21 星期一 10:55
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return root==null?true:isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left==null && right==null){return true;}
        if (left==null || right==null || left.val!=right.val){return false;}

        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }

    // 最开始写的代码：通过比较这两个代码进一步理解递归思路
    // 当前结点只负责当前结点的事，其他的交给递归
    /*private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left==null && right==null){return true;}
        if (left==null || right==null){return false;}

        if (left.right.val == right.left.val && left.left.val==right.right.val){
            return true;
        }else if (left.right.val != right.left.val || left.left.val!=right.right.val){
            return false;
        }

        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }*/

}

