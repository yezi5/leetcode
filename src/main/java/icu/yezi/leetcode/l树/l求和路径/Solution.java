package icu.yezi.leetcode.l树.l求和路径;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/paths-with-sum-lcci/
 * @PackageName icu.yezi.leetcode.l树.l求和路径
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/2 星期二 20:13
 */
public class Solution {

    private int rs = 0;

    public int pathSum(TreeNode root, int sum) {
        Dfs(root,sum);
        return rs;
    }

    public void dfs(TreeNode root, int sum){
        if (root == null) return;
        if (root.val == sum) rs++;
        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);
    }

    public void Dfs(TreeNode root, int sum){
        if (root == null) return;
        dfs(root,sum);
        Dfs(root.left,sum);
        Dfs(root.right,sum);
    }
}

