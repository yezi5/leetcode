package icu.yezi.dataStructure.tree.l二叉搜索树;

/**
 * @author 叶子
 * @Description 请设置
 * @PackageName icu.yezi.dataStructure.tree.l二叉搜索树
 * @DevelopmentTools IntelliJ IDEA
 * @Data 2020/12/20 星期日 10:39
 */
public class L基础操作 {

    /**
     * 增加结点
     * @param root 根结点
     * @param key 新增节点值
     * @return 根结点
     */
    public TreeNode add(TreeNode root,Integer key){
        if (root==null){
            root = new TreeNode(key);
        }

        if (root.val > key){
            root.left = add(root.left,key);
        }else if (root.val < key){
            root.right = add(root.right,key);
        }

        return root;
    }

    /**
     * 删除结点
     * @param root 根结点
     * @param key 删除结点值
     * @return 跟结点
     */
    public TreeNode delete(TreeNode root,Integer key){
        if (root==null){return null;}

        if (key<root.val){
            root.left=delete(root.left,key);
        }else if (key>root.val){
            root.right=delete(root.right,key);
        }else {
            // 处理删除叶子结点和删除只有一个子结点的结点两种情况
            if (root.left==null){
                return root.right;
            }else if (root.right==null){
                return root.left;
            }

            root.val = getMinVal(root.right);
            root.right = delete(root.right,root.val);
        }
        return root;
    }

    /**
     * 查找最小结点值
     * @param root
     * @return
     */
    public Integer getMinVal(TreeNode root){
        Integer data = root.val;
        while (root!=null){
            if (data>root.val){
                data = root.val;
            }
            root=root.left;
        }
        return data;
    }

    /**
     * 查找指定结点
     * @param root
     * @param key
     * @return
     */
    public TreeNode search(TreeNode root,Integer key){
        if (root==null || root.val==key){
            return root;
        }
        if (key>root.val){
            return search(root.right,key);
        }

        return search(root.left,key);
    }

    /**
     * 判断BST合法性
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root){
        return isValidBST(root,null,null);
    }

    /**
     * 判断BST合法性
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root==null){return true;}
        if (min!=null && root.val<=min.val){return false;}
        if (max!=null && root.val>=max.val){return false;}

        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }
}
