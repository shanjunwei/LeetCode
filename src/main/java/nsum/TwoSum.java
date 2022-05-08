package nsum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] result =  twoSum.twoSum(new int[]{3,2,4},6);
        List<Integer> list = Arrays.stream(result).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
    /**
     *  返回数据本身,不返回下标
     */
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        // 两个指针来回
        int low = 0,high= list.size() -1;
        while (low < list.size() && high >=0){
            int sum = list.get(low) + list.get(high);
            if(sum < target){
                low++;
            }else if(sum > target){
                high--;
            }else {
                return new int[]{nums[low],nums[high]};
            }
        }
        return new int[]{-1,-1};
    }
}

