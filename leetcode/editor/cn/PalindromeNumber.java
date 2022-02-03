//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学

package editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 *  测试修改
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));


        System.out.println(true ?  "yes":"false");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /** 字符串反转 **/
        public boolean isPalindrome2(int x) {
            char[]  str = String.valueOf(x).toCharArray();

            StringBuilder  builder  = new StringBuilder();
            for (int i = str.length -1; i >=0; i--) {
                builder.append(str[i]);
            }
            return builder.toString().equals(String.valueOf(x));
        }
        /** 非字符串反转解决方案**/
        public boolean isPalindrome(int x) {
           if(x < 0){
               return false;
           }
           int temp = x;
           List<Integer> list  = new ArrayList<>();
           while (temp % 10 !=0){
               list.add(temp % 10);
               temp  =  temp /10;
           }

            System.out.println(list);

           return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}