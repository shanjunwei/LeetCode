package recursive;

import java.util.Collections;
import java.util.HashMap;

public class PowSolution {
   // https://leetcode-cn.com/problems/powx-n/
    public double myPow(double x, int n) {
        if(n==-1) return 1/x;
        if(n ==0) return 1;
        if(n== 1) return x;
        if (n % 2 == 0) {
            // 若n为偶数
            double half = myPow(x,n/2);
            return  half * half ;
        }else{

            // 若n为奇数
            double half = myPow(x,n/2);
            if(n < 0) return half * half * 1/x;
            else  return  half * half * x;
        }
    }

    public static void main(String[] args) throws Exception{
//        PowSolution powSolution = new PowSolution();
//        System.out.println(powSolution.myPow(34.00515,-3));
//        System.out.println(Math.pow(34.00515,-3));
        System.out.println("utf-8编码下'abc'所占的字节数:" + "abc".getBytes("utf-8").length);
        System.out.println("gbk编码下'abc'所占的字节数:" + "abc".getBytes("gbk").length);
        System.out.println("utf-8编码下'你好'所占的字节数:" + "你好".getBytes("utf-8").length);
        System.out.println("gbk编码下你好'你好'所占的字节数:" + "你好".getBytes("gbk").length);

//        Collections.synchronizedMap(new HashMap<>());
    }
}
