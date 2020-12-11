package icu.yezi.dataStructure.tree.l普通的树;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叶子
 * @Description 树结点
 * @DevelopmentTools IntelliJ IDEA
 * @PackageName icu.yezi.dataStructure.tree.l普通的树
 * @Data 2020/12/10 星期四 20:53
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(Integer val) {
        this.val = val;
    }
}
