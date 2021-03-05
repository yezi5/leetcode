package icu.yezi.dataStructure.tree.l普通的树;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.dataStructure.tree.l普通的树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/5 星期五 19:40
 */
public class 基础算法 {

    /**
     * 计算树的最大深度
     * @param root
     * @return
     */
    public int depth(TreeNode root){
        if (root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }

    /**
     * 二叉树最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
}
