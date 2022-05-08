package recursive;

/**
 * 打家劫舍问题
 */
public class Rob {
    /**
     * 基础问题：
     *  你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *  给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        return dp(nums,nums.length-1);
    }
    /**
     *  dp[n] 偷到第n间房的最大收益; 递归函数
     *  对于第n间房，有两个选择
     *  dp[n] = max{dp[n-1] // n不偷 , dp[n-2] + nums[n] //n偷,则n-1不能偷 }
     */
    public int dp(int[] nums, int n) {
        if(n < 0) return  0;
        return Math.max(dp(nums,n-1),dp(nums,n-2)+nums[n]);
    }
    /**
     *  非递归实现,备忘录模式。从前到后
     */
    public int robNonDp(int[] nums) {
        // 备忘录中存着 i-2 和 i-1 的结果
        int[] memory =  new int[]{0,0};
        for (int i = 0; i < nums.length; i++) {
            int res = Math.max(memory[0] + nums[i],memory[1]);
            memory[0] = memory[1];
            memory[1] = res;
        }
        return memory[1];
    }
    /**
     *  非递归实现打家劫舍2,备忘录模式。从前到后
     */
    public int rob2NonDp2(int[] nums,int low ,int high) {
        int[] array = new int[]{0,0};
        int result = 0;
        for (int index = low; index <= high; index++) {
            result = Math.max(array[1],array[0] + nums[index]);
            array[0] = array[1];
            array[1] = result;
        }
        return result;
    }

    public int rob2Non(int[] nums) {
        if(nums.length == 0)  return 0;
        if(nums.length == 1)  return  nums[0];
        // 偷第一间房子
        int money1 = rob2NonDp2(nums,0, nums.length-2);
        // 不偷第一间房间
        int money2 = rob2NonDp2(nums,1, nums.length-1);
        return Math.max(money1,money2);
    }

    public int dp2(int[] nums, int n,int low,int high) {
        // 没有开始偷,收益为0
        if(n < 0) return  0;
        if(n < low || n > high) return 0;
        int rob_n_minus_1 = dp2(nums,n-1,low,high);
        int rob_n = dp2(nums,n-2,low,high)+nums[n];
        System.out.println(String.format("%s,n-1=%s,n=%s",n,rob_n_minus_1,rob_n));
        return Math.max(rob_n_minus_1,rob_n);
    }

    /**
     *  打家劫舍2。这个题目在基础的问题上加了一个条件,就是第一间房子和最后一间房间其实是相邻的
     */
    public int rob2_1(int[] nums) {
        return Math.max(dp2(nums, nums.length -2, 0,nums.length -2), dp2(nums, nums.length -2, 1,nums.length -1) ) ;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
//        System.out.println(rob.rob(new int[]{2,7,9,3,1}));
//        System.out.println(rob.dp(new int[]{2,7,9,3,1},0));

//        System.out.println(rob.robNonDp(new int[]{2,7,9,3,1}));
//        System.out.println(rob.rob2(new int[]{1,2,3,1}));
//        System.out.println(rob.rob2(new int[]{1,2,3,1}));
//        System.out.println(rob.dp2(new int[]{1,2,3,1},1,false));
//        System.out.println(rob.dp2(new int[]{1,2,3,1},0,true));
    }
}
