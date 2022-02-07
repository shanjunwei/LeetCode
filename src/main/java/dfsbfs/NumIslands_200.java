package dfsbfs;

import javafx.util.Pair;
import unionset.UnionFind;

import java.util.*;

/**
 * 岛屿数量
 */
public class NumIslands_200 {
    public static void main(String[] args) {
        // char[][]   grid = {{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},{'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},{'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        // 当前实现 grid[1][1] 元素存在重复染色问题
        NumIslands_200 bfsSolution = new NumIslands_200();
        System.out.println(bfsSolution.numIslands(grid));
    }
    //  广度优先搜索实现 队列 力扣ac通过
    public int numIslands1(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char seed = grid[i][j];
                if (seed == '1') {
                    grid[i][j] = '0';
                    result++;
                    // 深搜将所有叶子节点全部染色
                    LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
                    queue.add(new Pair<>(i, j));
                    while (!queue.isEmpty()) {
                        System.out.println(queue);
                        Pair<Integer, Integer> visit = queue.poll();
                        int row = visit.getKey();
                        int col = visit.getValue();
                        // 上
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.add(new Pair<>(row - 1, col));
                            grid[row - 1][col] = '0';  // 先行染色
                        }
                        // 下
                        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
                            queue.add(new Pair<>(row + 1, col));
                            grid[row +1 ][col] = '0';  // 先行染色
                        }
                        // 左
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.add(new Pair<>(row, col - 1));
                            grid[row][col-1] = '0';  // 先行染色
                        }
                        // 右
                        if (col + 1 < grid[row].length && grid[row][col + 1] == '1') {
                            queue.add(new Pair<>(row, col + 1));
                            grid[row ][col+1] = '0';  // 先行染色
                        }
                    }
                }
            }
        }
        return result;
    }
    // 深度优先搜索实现  栈  力扣ac通过
    public int numIslands2(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char seed = grid[i][j];
                if (seed == '1') {
                    grid[i][j] = '0';
                    result++;
                    Deque<Pair<Integer,Integer>>  stack = new ArrayDeque();
                    stack.add(new Pair<>(i,j));
                    while (!stack.isEmpty()){
                       Pair<Integer,Integer>  visit = stack.pollLast();
                        System.out.println(visit);
                        int row = visit.getKey();
                        int col = visit.getValue();
                        // 上
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            stack.add(new Pair<>(row - 1, col));
                            grid[row - 1][col] = '0';  // 先行染色
                        }
                        // 下
                        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
                            stack.add(new Pair<>(row + 1, col));
                            grid[row +1 ][col] = '0';  // 先行染色
                        }
                        // 左
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            stack.add(new Pair<>(row, col - 1));
                            grid[row][col-1] = '0';  // 先行染色
                        }
                        // 右
                        if (col + 1 < grid[row].length && grid[row][col + 1] == '1') {
                            stack.add(new Pair<>(row, col + 1));
                            grid[row ][col+1] = '0';  // 先行染色
                        }
                    }
                }
            }
        }
        return result;
    }
    // 并查集实现 岛屿数量 未完待续
    public static class Node {
        Pair<Integer,Integer>  data;
        public Node(int row, int col) {
            this.data = new Pair<>(row,col);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }
    private HashMap<Node, Node> fatherMap = new HashMap<>();  //  k->v k和v在同一个集合
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char seed = grid[i][j];
                if (seed == '1') {
                    int row = i, col = j;
                    // 自个组团
                    Node node = new Node(row, col);
                    fatherMap.put(node, node);  // 每个节点指向自己
                    // 上
                    if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                        fatherMap.put(node, new Node(row - 1, col));
                    }
                    // 左
                    if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                        fatherMap.put(node, new Node(row, col - 1));
                    }
                }
            }
        }
        return result;
    }



}
