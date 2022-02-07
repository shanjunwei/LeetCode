package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 *  全排列 回溯算法
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums,result,new ArrayList<>(),(1 << nums.length)-1);
        System.out.println(result);
        return result;
    }
    public void dfs(int[] nums,List<List<Integer>> result,List<Integer> temp,int trace) {
        if(trace == 0){  // 或者 temp的长度与result香等
            result.add(new ArrayList<>(temp));
        }
        // 计算出可选择的路径，横向遍历
        for (int index = 0; index < nums.length; index++) {
            if( ( ((trace) >> index)  & 1 ) ==1){
                temp.add(nums[index]);
                trace -= (1 << index);
                dfs(nums,result,temp,trace );
                // 回溯算法,在递归前进行了什么操作,递归后就要回退
                trace += (1 << index);
                temp.remove(temp.size()-1);
            }
        }
    }
}
