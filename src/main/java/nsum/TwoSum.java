package nsum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main2(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] result =  twoSum.twoSum(new int[]{3,2,4},6);
        List<Integer> list = Arrays.stream(result).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
    /**
     *  返回数据本身,不返回下标
     */
    public static  int[] twoSum(int[] nums, int target) {
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


    private static int  count(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // 两个指针来回
        int low = 0,high= list.size() -1;
        int count =0;
        while (low < list.size()){
            high = list.size() -1;
            if(list.get(low) + list.get(high) < target){
                low++;
                continue;
            }
            while (low < high){
                int sum = list.get(low) + list.get(high);
                System.out.printf("low=%s,high=%s,sum = %s \n",list.get(low),list.get(high),sum);
                if(sum > target){
                    high--;
                }
                if(sum < target) break;
                if(sum == target) {
                    count++;
                    System.out.printf("low=%s,high=%s \n",list.get(low),list.get(high));
                    high--;
                }
            }
            low ++;
        }
        return count;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.count(new int[]{1,7},8));
    }

}

