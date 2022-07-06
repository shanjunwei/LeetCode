package array;

import org.junit.Test;

public class Solution {

    // 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
    // 输入：n = 3
    //输出：[[1,2,3],[8,9,4],[7,6,5]]
    // https://leetcode.cn/problems/spiral-matrix-ii/
    public int[][] generateMatrix(int n) {
        if(n== 1) return new int[][]{{1}};
        int[][]  array = new int[n][n];
        int i = 0, j = 0;
        int count = 1;
        array[0][0] = 1;
        int flag= 1;
        while (i >= 0 && i < n && j >= 0 && j < n && (array[i][j] == 0 || flag == 1)) {
          //  System.out.printf("i=%s,j=%s \n",i,j);
            // 先一直右边
            flag  =0;
            while (j + 1 < n && array[i][j + 1] == 0) array[i][++j] = ++count;
            // 再一直下
            while (i + 1 < n && array[i + 1][j] == 0) array[++i][j] = ++count;
            // 一直左边
            while (j - 1 >= 0 && array[i][j - 1] == 0) array[i][--j] = ++count;
            // 一直上
            while (i - 1 >= 0 && array[i - 1][j] == 0){
                array[--i][j] = ++count;
                flag  =1;
            }
        }
       /* for (int k = 0; k < array.length; k++) {
            for (int l = 0; l < array[k].length; l++) {
                System.out.print(array[k][l] +" ");
            }
            System.out.println("");
        }*/
        return array;
    }
    @Test
    public void hasCycleTest() {
        Solution solution = new Solution();
        solution.generateMatrix(6);
    }
}
