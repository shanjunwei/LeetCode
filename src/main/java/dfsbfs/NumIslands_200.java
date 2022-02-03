package dfsbfs;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 岛屿数量
 * 当前版本存在重复计算的问题
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


    //  广度优先搜索实现 队列 力扣提交
    public int numIslands2(char[][] grid) {
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
    // 深度优先搜索实现  栈
    public int numIslands(char[][] grid) {
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
}
