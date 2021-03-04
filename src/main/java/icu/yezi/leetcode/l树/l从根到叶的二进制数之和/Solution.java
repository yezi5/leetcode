package icu.yezi.leetcode.l树.l从根到叶的二进制数之和;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 * @PackageName icu.yezi.leetcode.l树.l从根到叶的二进制数之和
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/4 星期四 15:17
 */
public class Solution {
    private int rs;

    public static void main(String[] args) {

    }

    public int sumRootToLeaf(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        find(root,stack);
        return rs;
    }

    /**
     * 解法一：
     * 基本思路
     * ① 查找到叶子节点的路径，保存二进制数
     * ② 将二进制数转换为十进制数并保存起来
     *
     * 效率不高，原因在于对每一条路径都进行了重新计算
     *
     * 观察树结构，我们会发现每条路径的差异仅仅是低位的改变
     *
     * 优化关键：优化进制转换算法
     *
     * 这里使用的进制转换算法： (1,0,0) --> 0*2的0次幂 + 0*2的1次幂 + 1*2的2次幂
     *
     * @param root
     * @param stack
     * @return
     */
    public TreeNode find(TreeNode root, Stack<Integer> stack){
        if (root == null){
            return null;
        }

        stack.push(root.val);
        TreeNode left = find(root.left,stack);
        TreeNode right = find(root.right,stack);

        // 调用计算方法
        if (left==null && right== null){
            calculate(stack);
        }

        stack.pop();

        return root;
    }

    public void calculate(Stack<Integer> stack){
        int sum = 0;
        for (int i = stack.size()-1,j=0; i >= 0; i--,j++) {
            sum += stack.get(i) * Math.pow(2,j);
        }
        rs += sum;
    }

    /**
     * 优化版
     * 这里的进制转换算法：
     * (1,0,0)
     *      0 * 2 + 1
     *     (0 * 2 + 1) * 2 + 0
     *    ((0 * 2 + 1) * 2 + 0) * 2 + 0
     *
     *
     * @param root
     * @param sum
     * @return
     */
    public TreeNode dfs(TreeNode root, int sum){
        if (root == null) return null;
        sum = sum*2 + root.val;

        TreeNode left = dfs(root.left,sum);
        TreeNode right = dfs(root.right,sum);

        if (left == null && right == null){
            rs += sum;
        }

        return root;
    }
}
