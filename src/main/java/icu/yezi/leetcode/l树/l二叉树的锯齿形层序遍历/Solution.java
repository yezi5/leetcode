package icu.yezi.leetcode.l树.l二叉树的锯齿形层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.l树.l二叉树的锯齿形层序遍历
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/7 星期日 9:18
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        bfs(root,lists);
        return lists;
    }

    public void bfs(TreeNode root, List<List<Integer>> lists){
        if (root == null) return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if (depth%2 != 0){
                // 左到右
                for (TreeNode node : queue) {
                    list.add(node.val);
                }
            }else {
                // 右到左
                for (int i = queue.size()-1; i >= 0; i--) {
                    list.add(queue.get(i).val);
                }
            }
            lists.add(list);

            for (int i = queue.size(); i > 0; i--) {
                TreeNode cure = queue.poll();
                if (cure.left != null){
                    queue.add(cure.left);
                }
                if (cure.right != null){
                    queue.add(cure.right);
                }
            }
            depth++;
        }
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
