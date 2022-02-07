package unionset;

import java.util.HashMap;
import java.util.List;

public class UnionFind {

    // 集合中的节点
    public static class Node {
        // whatever you like
    }
    // 借助的基础数据结构为HashMap
    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap;  //  k->v k和v在同一个集合
        public HashMap<Node, Integer> sizeMap;  // 集合内的节点数量
        public UnionFindSet() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }
        // 初始化所有节点
        public UnionFindSet(List<Node> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            makeSets(nodes);
        }
        // 初始化要给到所有样本
        public void makeSets(List<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);  // 每个节点指向自己
                sizeMap.put(node, 1);   // 每个节点各自的集合只有自己
            }
        }

        // 该方法不但能找到元素所在集合，而且还能将原来不扁平的集合打扁
        private Node findHead(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findHead(a);  // 这个过程会将集合a打扁
            Node bHead = findHead(b);
            if (aHead != bHead) {
                int aSetSize= sizeMap.get(aHead); // a所在集合的大小
                int bSetSize = sizeMap.get(bHead); // b所在集合的大小
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }

}
