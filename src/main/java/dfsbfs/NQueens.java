package dfsbfs;

/**
 *  N 皇后问题
 */
public class NQueens {

    // 打印n皇后问题
    public static void print(int n,int[] result) {
        if(result.length != n) return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j != result[i]) System.out.print("*");
                else System.out.print("Q");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(4,new int[]{1,3,0,2});
    }

}
