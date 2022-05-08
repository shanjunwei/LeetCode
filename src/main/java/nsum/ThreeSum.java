package nsum;

import java.util.*;
import java.util.stream.Collectors;
public class ThreeSum {
    /**
     *  两数之后有重复结果。进方法的list需要先排序
     */
    public List<List<Integer>> twoSum(List<Integer> list,int start, int target) {
        // 两个指针来回
        int low = start,high= list.size() -1;
        List<List<Integer>>  res = new LinkedList<>();
        while (low < high){
            while (low-1 >=0 && list.get(low-1).equals(list.get(low)) ) low++;
            while (high+1 < list.size() && list.get(high+1).equals(list.get(high))) high++;
            int sum = list.get(low) + list.get(high);
            if(sum < target){
                low++;
            }else if(sum > target){
                high--;
            }else {
                res.add(Arrays.asList(list.get(low),list.get(high)));
                low++;
                high--;
            }
        }
        return res;
    }
    /**
     *  利用两数和函数
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        //  首先对数字进行排序
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        List<List<Integer>> result = new LinkedList<>();
        System.out.println(list);
        List<Integer> temp = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int first = list.get(i);
            while (i - 1 >= 0 && list.get(i - 1).equals(list.get(i))) i++;
            LinkedList<Integer> tempList = new LinkedList<>(list);
            tempList.remove(i);
            List<List<Integer>> twoSumResult = twoSum(tempList,i, -first);
            if(twoSumResult.size()  > 0){
                for ( List<Integer> oneRes : twoSumResult){
                    result.add(new ArrayList(Arrays.asList(oneRes,first)));
                }
            }
        }
        return result;
    }
    /**
     * 优化,两个函数合成一个。避免求两数和问题
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //  首先对数字进行排序
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0  && nums[i-1] == nums[i]) continue;
            System.out.println("遍历:"+nums[i]);
            int low = i+1,high=nums.length-1;
            while (low <high){
                int sum = nums[i] + nums[low] + nums[high];
                System.out.println(String.format("low=%s,high=%s,index=%s;sum=%s",nums[low],nums[high],nums[i],sum));
                if(sum < 0){
                    low++;
                    while (low - 1 >= 0 && low < nums.length && nums[low - 1] == nums[low]) low++;
                }else if(sum > 0){
                    high--;
                    while (high >=0 && high + 1 < nums.length && nums[high + 1] == nums[high]) high--;
                }else {
                    result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    low++;
                    high--;
                    while (low - 1 >= 0 && low < nums.length && nums[low - 1] == nums[low]) low++;
                    while (high >=0 && high + 1 < nums.length && nums[high + 1] == nums[high]) high--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{0,0,0}));

    }
}
