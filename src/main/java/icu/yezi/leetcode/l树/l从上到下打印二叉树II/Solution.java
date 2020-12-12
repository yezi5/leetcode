package icu.yezi.leetcode.l树.l从上到下打印二叉树II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.l树.l从上到下打印二叉树II
 * @Data 2020/12/12 星期六 19:10
 */
public class Solution {
    /**
     * 广度优先算法
     * 队列实现
     *
     * 参考了LeetCode题解
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root==null){return listList;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();

            /**
             * 注意，这里的循环设置的很巧妙
             * i初始化值为当前层含有的结点数
             * 循环中queue新增的数据量不影响循环次数
             */
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cure = queue.poll();
                list.add(cure.val);
                if (cure.left!=null){
                    queue.add(cure.left);
                }
                if (cure.right!=null){
                    queue.add(cure.right);
                }
            }
            listList.add(list);
        }

        return listList;
    }

    public int[] test(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null){
            queue.add(root);
        }

        while (!queue.isEmpty()){
            TreeNode cure = queue.poll();
            list.add(cure.val);
            if (cure.left!=null){
                queue.add(cure.left);
            }
            if (cure.right!=null){
                queue.add(cure.right);
            }
        }

        int size = list.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}

