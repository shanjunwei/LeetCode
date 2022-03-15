package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  N 皇后问题问题
 *  力扣
 */
public class NQueens {
    // 打印n皇后问题
    public static List<String> print(int n, List<Integer> solution) {
        List<String> result = new ArrayList<>();
        if(solution.size() != n) return result;
        for (int i = 0; i < n; i++) {
            StringBuilder linBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if(j != solution.get(i))  linBuilder.append(".");
                // System.out.print(".");
                else linBuilder.append("Q");
            }
            result.add(linBuilder.toString());
        }
        return result;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueensDfs(n,0,new int[n][n],new LinkedList<>(),result);
        System.out.println(result);
        return result;
    }

    public void solveNQueensDfs(int n, int depth, int[][] chessboard, LinkedList<Integer> solution, List<List<String>> result) {
        if(depth >= n){
            System.out.println(solution);
            result.add(print(n,solution));
            return;
        }
        // 横向选择
        for (int i = 0; i < chessboard[depth].length ; i++) {
            // 决策树
            if(!solution.contains(i) && chessboard[depth][i] <= 0){
                solution.add(i);
                // 执行 皇后 横、竖、撇、捺 的清道
                cleanTheRoad(depth,i,chessboard,false);
                depth++;
                solveNQueensDfs(n,depth,chessboard,solution,result);
                // 执行回滚
                depth--;
                cleanTheRoad(depth,i,chessboard,true);
                solution.remove(solution.size()-1);
            }
        }
    }

    public void cleanTheRoad(int i,int j,int[][] chessboard,boolean rollback) {
        int tempI = i,temJ =j;
        while (++tempI  <  chessboard.length && --temJ >=0){
            // 执行撇清道
            chessboard[tempI][temJ] = rollback ? chessboard[tempI][temJ] - (i+1) :chessboard[tempI][temJ] + i+1;
        }
        tempI = i;
        temJ = j;
        while (++tempI < chessboard.length && ++temJ < chessboard.length){
            // 执行捺清道
            chessboard[tempI][temJ] = rollback ? chessboard[tempI][temJ] - (i+1) :chessboard[tempI][temJ] + i+1;
        }
    }

    public static void main(String[] args) {
//        System.out.println(print(4, Arrays.asList(1,3,0,2)));
        NQueens nQueens  = new NQueens();
        nQueens.solveNQueens(4);
    }

}
