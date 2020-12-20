package icu.yezi.leetcode.l树.BST合法性判断;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 * @PackageName icu.yezi.leetcode.l树.BST合法性判断
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/20 星期日 12:12
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }

    public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){
        if(root==null){return true;}

        if(min!=null && root.val<=min.val){return false;}
        if(max!=null && root.val>=max.val){return false;}

        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }
}


