package icu.yezi.dataStructure.tree.l普通的树;

import java.util.Stack;

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
public class Tree {

    public static void main(String[] args) {
        TreeNode root = initTree();

    }

    public static TreeNode initTree(){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);

        return root;
    }


    /**
     * 递归实现前序遍历
     * @param node
     */
    public static void preTraversal(TreeNode node){
        if (node==null){return;}
        System.out.println(node.getVal());

        if (node.getLeft() != null){
            preTraversal(node.getLeft());
        }
        if (node.getRight() != null){
            preTraversal(node.getRight());
        }
    }

    /**
     * 迭代实现前序遍历
     * @param root
     */
    public static void pre(TreeNode root){
        if (root==null){return;}
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = null;
        stack.push(root);

        while (!stack.isEmpty()){
            temp = stack.pop();
            System.out.println(temp.getVal());
            if (temp.getRight()!=null){
                stack.push(temp.getRight());
            }
            if (temp.getLeft()!=null){
                stack.push(temp.getLeft());
            }
        }

    }

    /**
     * 递归实现中序遍历
     * @param node
     */
    public static void midTraversal(TreeNode node){
        if (node==null){return;}
        if (node.getLeft() != null){
            preTraversal(node.getLeft());
        }
        System.out.println(node.getVal());
        if (node.getRight() != null){
            preTraversal(node.getRight());
        }
    }

    /**
     * 递归实现后序遍历
     * @param node
     */
    public static void postTraversal(TreeNode node){
        if (node==null){return;}
        if (node.getLeft() != null){
            preTraversal(node.getLeft());
        }
        if (node.getRight() != null){
            preTraversal(node.getRight());
        }
        System.out.println(node.getVal());
    }
}
