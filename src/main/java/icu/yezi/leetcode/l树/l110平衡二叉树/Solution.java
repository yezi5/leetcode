package icu.yezi.leetcode.l树.l110平衡二叉树;

/**
 * @author 叶子
 * @Description 请设置
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.l树.l110平衡二叉树
 * @Data 2020/12/15 星期二 18:25
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }else{
            return Math.abs(height(root.left)-height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;

    }
}

