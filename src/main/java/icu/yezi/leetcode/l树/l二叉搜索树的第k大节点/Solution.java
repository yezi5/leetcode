package icu.yezi.leetcode.l树.l二叉搜索树的第k大节点;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 叶子
 * @Description https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.leetcode.l树.l二叉搜索树的第k大节点
 * @Data 2020/12/15 星期二 19:49
 */
public class Solution {

    private int res;
    private int k;

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        root.left = node1;
        root.right = node3;
        node1.right = node4;

        System.out.println(solution.kthLargest(root, 1));

    }

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    /**
     * 中序逆序深搜
     * @param node
     */
    void dfs(TreeNode node){
        if (node==null){
            return;
        }
        dfs(node.right);
        if (--k==0){
            res = node.val;
            return; //避免后续无用的递归操作
        }
        dfs(node.left);
    }


    /**
     * 迭代中序倒序实现
     * @param root
     * @param k
     * @return
     */
    public int reverseOrder(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack();
        int count = 0;
        TreeNode cure = root;

        while (cure!=null || !stack.isEmpty()){
            while (cure!=null){
                stack.push(cure);
                cure = cure.right;
            }
            cure = stack.pop();
            count++;
            if (count==k){
                break;
            }
            cure = cure.left;
        }
        return cure.val;
    }



    /**
     * 最low解
     * @param root
     * @param k
     * @return
     */
    public int test1(TreeNode root, int k){
        List<Integer> list = inOrderTraversal(root);
        return list.get(list.size()-k);
    }

    private List<Integer> inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cure = root;

        while (cure!=null || !stack.isEmpty()){
            //左子结点入栈
            while (cure!=null){
                stack.push(cure);
                cure=cure.left;
            }
            cure=stack.pop();
            list.add(cure.val);
            cure=cure.right;
        }

        return list;
    }
}

