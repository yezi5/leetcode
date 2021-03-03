package icu.yezi.leetcode.l树.l二叉树的最近公共祖先;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @PackageName icu.yezi.leetcode.l树.l二叉树的最近公共祖先
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/3 星期三 20:40
 */
public class Solution {

    /**
     * 多版本，由简单到复杂一步步深入理解
     *
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return method1(root,p,q);
    }

    // 自顶向下递归
    /**
     * 思路简单，容易理解，时间复杂度高
     *
     * 在以 root 为根结点的树中
     * 根据最近公共祖先的定义，我们可以知道最近公共祖先的位置存在以下几种情况
     * ① p q 在root子树的异侧，root就是 result
     * ② p q 在root左子树上，则 result 必定在root左子树上，继续对root左子树递归
     * ③ p q 在root右子树上，同②
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode method1(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) return root;

        boolean pInLeft = method1_find(root.left,p) != null;
        boolean pInRight = !pInLeft;

        boolean qInLeft = method1_find(root.left,q) != null;
        boolean qInRight = !qInLeft;
        // p q 在root同侧子树
        if (pInLeft && qInLeft) return method1(root.left,p,q);
        if (pInRight && qInRight) return method1(root.right,p,q);
        // p q 在root异侧子树
        return root;
    }

    /**
     * 在子树中查找指定结点
     * @param root
     * @param node
     * @return 存在指定结点就返回该结点，不存在就返回null
     */
    public TreeNode method1_find(TreeNode root, TreeNode node){
        if (root == null || root == node) return root;

        TreeNode left = method1_find(root.left,node);
        TreeNode right = method1_find(root.right,node);

        return left == null ? right : left;
    }

    /**
     * 优化后的算法
     *
     * 在子树中同时查找 p q 结点，找到就返回，无论是哪个
     * ① left = null  p q 均在右子树
     * ② right = null  p q 均在左子树
     * ③ 二者都不是 null， p q 在子树异侧，root就是result
     *
     * 若是情况①②，两结点在同侧子树，由于我们自顶向下查找结点，所以另一侧子树查找结果就是 result
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode method2(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) return root;

        TreeNode left = method2(root.left,p,q);
        TreeNode right = method2(root.right,p,q);
        // p q 在root同侧子树
        if (left == null) return right;
        if (right == null) return left;
        // p q 在root异侧子树
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
