package number;

/**
 * @description: 整数类型题目
 * @author: shan junwei
 * @create: 2019-09-06 22:51
 **/

public class Solution {


    public int reverse(int x) {

        if (x >= 0) {
            // 一个思路，先转成字符串，然后从后往前遍历
            char[] num = String.valueOf(x).toCharArray();
            //System.out.println();
            String ret = "";
            for (int i = num.length - 1; i >= 0; i--) {
                ret = ret.concat(num[i] + "");
            }
            int result = 0;
            try {
                result = Integer.parseInt(ret);
            } catch (Exception ex) {
                ex.printStackTrace();
                return result;
            }
            return result;
        } else {
            x = -x;
            // 一个思路，先转成字符串，然后从后往前遍历
            char[] num = String.valueOf(x).toCharArray();
            //System.out.println();
            String ret = "";
            for (int i = num.length - 1; i >= 0; i--) {
                ret = ret.concat(num[i] + "");
            }

            int result = 0;
            try {
                result = Integer.parseInt(ret);
            } catch (Exception ex) {
                ex.printStackTrace();
                return result;
            }
            return -result;
           // return -Integer.parseInt(ret);
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.reverse(1534236469));
    }
}
