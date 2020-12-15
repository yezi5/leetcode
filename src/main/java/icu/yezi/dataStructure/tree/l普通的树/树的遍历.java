package icu.yezi.dataStructure.tree.l普通的树;

import icu.yezi.leetcode.l树.l94二叉树的中序遍历.Solution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * 一点思考：
 *  递归本身使用的就是栈的思想，所以理论上递归能够解决的问题，同样能够用栈来解决
 *
 *  树的遍历的递归实现中，每次都是先遍历左子树，其实就可以理解为：
 *      1. 先将右子结点压入栈，再将左子结点压入栈
 *      2. 弹出左子结点，进行下一轮操作
 *
 * @author 叶子
 * @Description 树的各种操作
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.dataStructure.tree.l普通的树
 * @Data 2020/12/10 星期四 20:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class 树的遍历 {
    
    private TreeNode root;

    public static void main(String[] args) {
        TreeNode node = initTree();
        树的遍历 s = new 树的遍历();
        s.post(node);
    }

    /**
     * 初始化树
     * @return
     */
    public static TreeNode initTree(){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node3.left = node5;
        node3.right = node4;

        return root;
    }

    /**
     * 递归实现前序遍历
     * @param node
     */
    public  void preTraversal(TreeNode node){
        if (node==null){return;}
        System.out.println(node.val);

        if (node.left != null){
            preTraversal(node.left);
        }
        if (node.right != null){
            preTraversal(node.right);
        }
    }

    /**
     * 迭代实现前序遍历
     * @param root
     */
    public  void pre(TreeNode root){
        if (root==null){return;}
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = null;
        stack.push(root);

        while (!stack.isEmpty()){
            temp = stack.pop();
            System.out.println(temp.val);
            if (temp.right!=null){
                stack.push(temp.right);
            }
            if (temp.left!=null){
                stack.push(temp.left);
            }
        }

    }

    /**
     * 递归实现中序遍历
     * @param node
     */
    public  void midTraversal(TreeNode node){
        if (node==null){return;}
        if (node.left != null){
            midTraversal(node.left);
        }
        System.out.println(node.val);
        if (node.right != null){
            midTraversal(node.right);
        }
    }

    /**
     * 迭代实现中序遍历
     * @param root
     */
    public  void mid(TreeNode root){
        if (root==null){return;}
        TreeNode cure = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cure!=null||!stack.isEmpty()){
            //将左子树左子结点全部入栈
            while (cure!=null){
                stack.push(cure);
                cure=cure.left;
            }
            //打印中间结点
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            //处理右子树结点
            cure=temp.right;
        }
    }

    /**
     * 递归实现后序遍历
     * @param node
     */
    public  void postTraversal(TreeNode node){
        if (node==null){return;}
        if (node.left != null){
            postTraversal(node.left);
        }
        if (node.right != null){
            postTraversal(node.right);
        }
        System.out.println(node.val);
    }

    /**
     * 迭代实现后序遍历
     * @param root
     */
    public  void post(TreeNode root){
        if (root==null){return;}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //记录已经处理过的结点
        List<TreeNode> list = new ArrayList<>();

        while (!stack.isEmpty()){
            TreeNode cure = stack.peek();
            if (cure.left!=null && !list.contains(cure.left)){
                stack.push(cure.left);
            }else if (cure.right!=null && !list.contains(cure.right)){
                stack.push(cure.right);
            }else {
                list.add(cure);
                System.out.println(cure.val);
                stack.pop();
            }
        }
    }

    /**
     * BFS算法实现层序遍历
     * 使用队列
     * @param root
     */
    public void sequenceTraversal(TreeNode root){
        if (root==null){return;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode cure = queue.poll();
            System.out.printf("%d ",cure.val);
            if (cure.left!=null){
                queue.add(cure.left);
            }
            if (cure.right!=null){
                queue.add(cure.right);
            }
        }

        /*while (!queue.isEmpty()){
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cure = queue.poll();
                System.out.printf("%d ",cure.val);
                if (cure.left!=null){
                    queue.add(cure.left);
                }
                if (cure.right!=null){
                    queue.add(cure.right);
                }
            }
        }*/
    }

}
