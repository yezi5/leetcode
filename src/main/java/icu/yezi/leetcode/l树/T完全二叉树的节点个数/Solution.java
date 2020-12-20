package icu.yezi.leetcode.l树.T完全二叉树的节点个数;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.l树.T完全二叉树的节点个数
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/20 星期日 12:18
 */
public class Solution {

    public int countNodes(TreeNode root) {
        int lh = 0;
        int rh = 0;
        TreeNode l = root;
        TreeNode r = root;

        while (l!=null){
            lh++;
            l=l.left;
        }
        while (r!=null){
            rh++;
            r=r.right;
        }
        if (lh==rh){
            return (int)Math.pow(2,lh)-1;
        }

        return countNodes(root.left)+countNodes(root.right)+1;
    }
}

