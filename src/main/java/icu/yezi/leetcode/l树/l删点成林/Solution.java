package icu.yezi.leetcode.l树.l删点成林;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.l树.l删点成林
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2021/3/7 星期日 10:57
 */
public class Solution {
    private Set<Integer> delete;
    List<TreeNode> res=new ArrayList<>();

    /**
     * 另一位大佬的思路
     * 感觉和自己写的第一种解决方案一样，但是效率却天差地别
     *
     * @param root
     * @param to_delete
     * @return
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> hashset = new HashSet<>();
        for (int i : to_delete) hashset.add(i);
        if (!hashset.contains(root.val)) res.add(root);
        DFS(root,hashset);
        return res;
    }

    public TreeNode DFS(TreeNode root,Set<Integer> hashset) {
        if (root == null) return null;
        root.left = DFS(root.left,hashset);
        root.right = DFS(root.right,hashset);
        if (hashset.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            root = null;
        }
        return root;
    }

    /**
     * 力扣大佬思路：
     *
     * 后序遍历，当前结点加入结果集需要满足两个条件
     * ① 不被删除
     * ② 父结点不存在
     *  引入参数parentExists 判断父结点存在性
     * 子结点删除，父结点要进行更新
     *
     *
     * @param root
     * @param to_delete
     * @return
     */
    public List<TreeNode> method2(TreeNode root, int[] to_delete){
        List<TreeNode> list = new ArrayList<>();
        helper(root,false,list);
        return list;
    }

    public boolean helper(TreeNode root, boolean parentExists,List<TreeNode> list){
        boolean del = false;
        if (root == null){
            return del;
        }
        del = delete.contains(root.val);

        if (helper(root.left,!del,list)){
            root.left = null;
        }
        if (helper(root.right,!del,list)){
            root.right = null;
        }

        if (!del && !parentExists){
            list.add(root);
        }

        return del;
    }

    public List<TreeNode> method1(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        TreeNode cure = traverse(root,list);
        if (cure!=null) list.add(cure);

        return list;
    }

    /**
     * 后序遍历
     * 当前结点要删除，非空子树加入结果集，并返回null
     * 当前结点不需要删除，返回当前结点
     *
     * @param root
     * @param list
     */
    public TreeNode traverse(TreeNode root, List<TreeNode> list){
        if (root == null) return root;
        root.left = traverse(root.left,list);
        root.right = traverse(root.right,list);
        if (delete.contains(root.val)){
            if (root.left != null) list.add(root.left);
            if (root.right != null) list.add(root.right);
            return null;
        }
        return root;
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
