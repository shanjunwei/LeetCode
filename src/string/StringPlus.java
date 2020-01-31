package string;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 * @description: 字符串相加
 * @author: shan junwei
 * @create: 2020-01-31 10:58
 **/

public class StringPlus {


    public String addStrings(String num1, String num2) {
        int index = Math.max(num1.length(), num2.length()) - 1;
        int maxIndex = index;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        while (index >= 0) {
            int left = 0;
            int right = 0;
            int p1 = index - (maxIndex - num1.length() + 1);
            int p2 = index - (maxIndex - num2.length() + 1);
            if (p1 >= 0) {
                char leftNum = num1.charAt(p1);
                if (!Character.isDigit(leftNum)) {
                    return -1 + "";
                }
                left = Integer.parseInt(String.valueOf(leftNum));
            }
            if (p2 >= 0) {
                char rightNum = num2.charAt(p2);
                if (!Character.isDigit(rightNum)) {
                    return -1 + "";
                }
                right = Integer.parseInt(String.valueOf(rightNum));
            }
            Pair<Integer, Integer> pair = new Pair<>(left, right);
            list.add(pair);
            index--;
        }

        return plusFunc(list,0,0);
    }


    private String plusFunc(List<Pair<Integer, Integer>> list, int index, int extra) {
        // 递归终结
        if(index >=  list.size() && extra == 0){
            return  "";
        }
        int num1;
        int num2;
        if(index < list.size()){
            num1 = list.get(index).getKey();
            num2 = list.get(index).getValue();
        }else{
            num1 = 0;
            num2 = 0;
        }
        if (String.valueOf(num1).length() > 1 || String.valueOf(num2).length() > 1) {
            return "";
        }
        int plus = num1 + num2 + extra;
        // 取出个位数
        int units = plus % 10;
        // 取出十位数
        int tens = plus / 10;

        return  plusFunc(list, ++index, tens) + units;
    }

    public static void main(String[] args) {
        StringPlus stringPlus = new StringPlus();
        String result = stringPlus.addStrings("1", "9");

        System.out.println(result);
    }

}
