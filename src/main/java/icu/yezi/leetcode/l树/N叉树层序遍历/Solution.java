package icu.yezi.leetcode.l树.N叉树层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.leetcode.l树.N叉树层序遍历
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/18 星期五 11:15
 */
public class Solution  {

    /**
     * 队列实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
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
