package tree;

import java.util.List;

/**
 * @description: 树的节点
 * @author: shan junwei
 * @create: 2019-09-14 21:26
 **/

public class TreeNode {

    int val;
    List<TreeNode>  childNodes;

    TreeNode(int x) {
        val = x;
    }
}
