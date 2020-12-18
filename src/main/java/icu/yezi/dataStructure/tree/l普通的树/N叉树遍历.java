package icu.yezi.dataStructure.tree.l普通的树;


import java.util.*;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.dataStructure.tree.l普通的树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/18 星期五 10:55
 */
public class N叉树遍历 {

    /**
     * 递归实现前序遍历
     * @param node
     * @param list
     */
    public void preTraverse(Node node, List<Integer> list){
        if (node==null){return;}
        for (Node child : node.children) {
            list.add(child.val);
            preTraverse(child,list);
        }
    }

    /**
     * 迭代实现前序遍历
     * 套用迭代实现树的前序遍历算法的思想
     * 对二叉树的遍历算法略作修改
     * @param root
     * @return
     */
    public List<Integer> preTraverse(Node root){
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root!=null){
            stack.push(root);
        }

        while (!stack.isEmpty()){
            Node cure = stack.pop();
            list.add(cure.val);

            for (int i = cure.children.size()-1; i >= 0; i--) {
                stack.push(cure.children.get(i));
            }
        }
        return list;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postTraverse(Node root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        if (root!=null){
            list.add(root.val);
        }
        return list;
    }

    /**
     * 递归实现后序遍历
     * @param node
     * @param list
     */
    private void traverse(Node node, List<Integer> list) {
        if (node==null){return;}
        for (Node child : node.children) {
            traverse(child,list);
            list.add(child.val);
        }
    }

    /**
     * 迭代实现层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> sequenceTraverse(Node root) {
        Queue<Node> queue = new LinkedList();
        List<List<Integer>> listList = new ArrayList<>();
        if (root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Node cure = queue.poll();
                list.add(cure.val);
                queue.addAll(cure.children);
            }
            listList.add(list);
        }
        return listList;
    }
}
