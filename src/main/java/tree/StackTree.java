package tree;

import java.util.Stack;

public class StackTree {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right =treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;


        // 用栈dfs 先顺序
        Stack<TreeNode>  stack = new Stack<>();
        stack.push(treeNode1);
        while (!stack.isEmpty()){
            TreeNode treeNode =  stack.pop();
            System.out.println(treeNode.data);
            if(treeNode.right!= null) stack.push(treeNode.right);
            if(treeNode.left!= null)  stack.push(treeNode.left);
        }
        System.out.println("前序遍历完成");

        stack.clear();
        // 中顺序
        // 1, 定一个中间结点, 赋值根节点
        TreeNode mid = treeNode1;
        while (!stack.isEmpty() || mid != null) {
            while (mid != null) {
                stack.push(mid);
                mid = mid.left;
            }
            //出栈遍历
            TreeNode pop = stack.pop();
            System.out.println(""+pop.data);
            //标记转移到出栈遍历元素的right
            mid = pop.right;
        }
        System.out.println("中序遍历完成");
    }

}
