package num;

import java.util.*;
import java.util.stream.Collectors;


public class TwoSum {
    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer,Integer>  valueIndexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            valueIndexMap.put(numbers[i],i+1);
        }
        for (int i = 0; i < numbers.length; i++) {
            if(Math.abs(numbers[i]) > target){
                break;
            }
            if(valueIndexMap.containsKey(target - numbers[i])){
                return new int[]{i+1,valueIndexMap.get(target - numbers[i])};
            }
        }
        return new int[]{-1,-1};
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>  valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valueIndexMap.put(nums[i],i+1);
        }
        for (int i = 0; i < nums.length; i++) {
            if(valueIndexMap.containsKey(target - nums[i])){
                if(i == valueIndexMap.get(target - nums[i])){
                    continue;
                }
                return new int[]{i+1,valueIndexMap.get(target - nums[i])};
            }
        }
        return new int[]{-1,-1};
    }

}
