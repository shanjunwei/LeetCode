package backtrack;

import java.util.*;

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
    /**
     *  电话号码的字母组合,全排列
     */
    Map<Character,List<String>>  digitMap = new HashMap(){{
        put('1', Arrays.asList()); put('2', Arrays.asList("a,b,c".split(","))); put('3', Arrays.asList("d,e,f".split(",")));
        put('4', Arrays.asList("g,h,i".split(","))); put('5', Arrays.asList("j,k,l".split(","))); put('6', Arrays.asList("m,n,o".split(",")));
        put('7', Arrays.asList("p,q,r,s".split(","))); put('8', Arrays.asList("t,u,v".split(","))); put('9',
                Arrays.asList("w,x,y,z".split(",")));
    }};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinationsDfs(digits,0,result,new ArrayList<>());
        return result;
    }

    public void letterCombinationsDfs(String digits,int index,List<String> result,List<String> temp) {
        if (index > digits.length()-1) {
            String tempResult = String.join("",temp);
            if(!"".equals(tempResult)){
                result.add(tempResult);
            }
            return;
        }
        // 横向选择
        // 当前数字
        Character current = digits.charAt(index);
        for (  int i = 0; i < digitMap.get(current).size(); i++) {
            // 横向选择一个字符
            String character =   digitMap.get(current).get(i);
           temp.add(String.valueOf(character));
           index++;
           // dfs纵向遍历
            letterCombinationsDfs(digits,index,result,temp);
            // 回溯在dfs之前做了啥,这里就进行回退
            index--;
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.letterCombinations("23"));
    }
}
