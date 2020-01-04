package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 字符串排列组合
 * @author: shan junwei
 * @create: 2019-08-11 15:30
 **/

public class Permutations {

    public static final List<List<String>> results = new ArrayList<>();


    public void getSubPermutations(String s) {
        char[] array = s.toCharArray();
        if (array.length == 0) {
            return;
        }


    }

    public void permutation(char[] s, int from, int to) {
        if (to <= 1)
            return;
        if (from == to) {
            System.out.println(s);
        } else {
            for (int i = from; i <= to; i++) {
                //交换前缀，使其产生下一个前缀
                swap(s, i, from);
                permutation(s, from + 1, to);
                //将前缀换回，继续做上一个前缀的排列
                swap(s, from, i);
            }
        }
    }


    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.permutation("abc".toCharArray(), 0, 2);
    }




 /*   public boolean isContains(int[] nums, int current, int flag) {

        int left = flag - current;


    }*/


}
