package icu.yezi.leetcode.l树.l好叶子节点对的数量;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs/
 * @PackageName icu.yezi.leetcode.l树.l好叶子节点对的数量
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/6 星期六 16:01
 */
public class Solution {
    private int rs;

    public int countPairs(TreeNode root, int distance) {
        Dfs(root,distance);

        return rs;
    }
    public void Dfs(TreeNode root, int distance){
        if (root == null) return;
        List<Integer> leftList = new ArrayList<>(20);
        List<Integer> rightList = new ArrayList<>(20);

        dfs(root.left,leftList,1);
        dfs(root.right,rightList,1);

        for (int i = 0; i < leftList.size(); i++) {
            for (int l = 0; l < rightList.size(); l++) {
                if ((leftList.get(i) + rightList.get(l)) <= distance){
                    rs++;
                }
            }
        }
        Dfs(root.left,distance);
        Dfs(root.right,distance);
    }

    public void dfs(TreeNode root, List<Integer> list, int length){
        if (root == null) return;

        if (root.left==null && root.right==null){
            list.add(length);
        }
        dfs(root.left,list,length+1);
        dfs(root.right,list,length+1);
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
