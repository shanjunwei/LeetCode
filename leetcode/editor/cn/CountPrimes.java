//统计所有小于非负整数 n 的质数的数量。
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7
// 
// Related Topics 哈希表 数学

package editor.cn;

public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();

        System.out.println(solution.countPrimes(10));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (primeDecomposition(i)) {
                    count++;
                }
            }
            return count;
        }


        // 质因数分解

        private boolean primeDecomposition(int primeNum) {
            // int[]  array  = new int[];
            int prime_cnt = 0;
            for (int i = 2; i * i <= primeNum; ++i) {
                if (primeNum % i == 0) {
                    //array[prime_cnt++] = i;
                    prime_cnt++;
                    while (primeNum % i == 0) {
                        primeNum /= i;
                    }
                }
            }
            if (primeNum != 1) {
                // array[prime_cnt++] = primeNum;
                prime_cnt++;
            }
            return prime_cnt >= 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}