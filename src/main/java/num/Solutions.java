package num;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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
    /**
     * 给定一个 范围从1 到n+1的 n+1个数
     * 给定一个数组长度为n
     * 有一个数不在数组里,求这个数。 时间O(n) 空间O(1)
     * https://blog.csdn.net/rerli/article/details/19041#508832
     * 米哈游数据平台二面面试题
     */
    public int theLostNum(int[] nums) {
        // 原地排序
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current > nums.length) {
                nums[i] = 0;
            }
            // 数据不在所在的位置上
            else if (nums[i] != i + 1) {
                // 下标 current - 1 和 i 进行数据交换
                int temp = nums[current - 1];
                nums[current - 1] = current;
                nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
        // 找出漏的数据
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return i + 1;
        }
        return -1;
    }
    @Test
    public void testLostNum() {
        Solutions solutions = new Solutions();
        Assert.assertEquals(4,solutions.theLostNum(new int[]{1,2,3,5}));
    }
}
