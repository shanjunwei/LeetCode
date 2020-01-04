  //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [-2,-2,3,-2]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [0,1,0,1,0,1,99]
//输出: 99 
// Related Topics 位运算


/*  出现3次就不能再用异或的方法了，因为三个相同的数异或还是得到本身。
          但是还是可以采用位运算的思想，因为出现三次的数字每个位（0或者1）也是出现三次，因此可以每一位的和能够被3整除（对3取余为0）。
          所以如果把每个数的二进制表示的每一位加起来，对于每一位的和，如果能被3整除，那对应那个只出现一次的数字的那一位就是0，否则对应的那一位是1。*/

  
  package editor.cn;

  import org.junit.Assert;
  import org.junit.Test;

  public class SingleNumberIi{
      public static void main(String[] args) {
           Solution solution = new SingleNumberIi().new Solution();
           int result  = solution.singleNumber(new int[]{43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43});

           // 43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43]
          //			测试结果:-18790

      }

      @Test
      public static void UnitTest() {
          Solution solution = new SingleNumberIi().new Solution();
          int[] array1 = new int[]{-19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28};
          int result1  = solution.singleNumber(array1);
          Assert.assertEquals(-28,result1);
      }

      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        long[] array = new long[33];
        for( int  num : nums){
            if(num < 0 ){
                array[array.length-1] += 1;
                num = -num;
            }
            for (int i = 0; i < array.length-1; i++) {
                array[i] +=  num & (1 << i);
            }
        }
        int result = 0;
        for (int i = 0; i < array.length-1; i++) {
            long item =  array[i];
            if(item % 3 ==0){
            }else{
                result += (1 << i);
            }
        }
        if(array[array.length-1] % 3 != 0){
            result  = - result;
        }
        System.out.println(result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }