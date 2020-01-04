package tree;

import java.util.ArrayList;

/**
 * @description: 树的遍历
 * @author: shan junwei
 * @create: 2019-09-14 21:27
 **/

public class Solutions {


    public static TreeNode initTree() {
        TreeNode root = new TreeNode(1);
        root.childNodes = new ArrayList<>();


        TreeNode tree2 = new TreeNode(2);
        tree2.childNodes = new ArrayList<>();
        tree2.childNodes.add(new TreeNode(5));
        tree2.childNodes.add(new TreeNode(6));
        tree2.childNodes.add(new TreeNode(7));

        root.childNodes.add(tree2);
        root.childNodes.add(new TreeNode(3));
        root.childNodes.add(new TreeNode(4));
        return root;
    }

    // 递归便利多叉树
    public static void foreachTree(TreeNode node,String memory) {
        // 先遍历跟节点
        memory = memory.concat(node.val+"->");
        System.out.print(memory + " ->");
        if(node.childNodes !=null){
            for (TreeNode  tree  :node.childNodes){
                if(tree != null){
                    foreachTree(tree,memory);

                }
            }
        }
        memory = "";
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode  root =   initTree();
        foreachTree(root,"");
    }
}
