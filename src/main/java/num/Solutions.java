package num;

import org.junit.Assert;
import org.junit.Test;

public class Solutions {
    /**
     * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 链接：https://leetcode.cn/problems/majority-element
     */
    public int majorityElement(int[] nums) {
        // count众数出现的次数
        int x=-1,count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count==0){
                x=nums[i];count++;
            }
            else if(nums[i] == x){
                count++;
            } else{
                count--;
            }
            System.out.printf("nums[i]=%s,x=%s,count=%s\n",nums[i],x,count);
        }
        return x;
    }
    @Test
    public  void majorityElementTest() {
        int[] nums = {1,2,2,1,3,2,2};
        Solutions solutions = new Solutions();
        Assert.assertEquals(2,solutions.majorityElement(nums));
    }
}
