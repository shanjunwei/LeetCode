package number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: int转罗马数字
 * @author: shan junwei
 * @create: 2020-01-28 13:06
 **/

public class IntToRoma {

    private static Map<Integer, String> romanMap = new HashMap<>();

    static {
        initMap(romanMap);
    }


    private static void initMap(Map<Integer, String> map) {
        if (map == null) {
            return;
        }
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }


    List<Integer> keyList = new ArrayList<>(romanMap.keySet());


    public String intToRoman(int num) {

        // 先把数字按位拆开
        List<Integer> resultList = partition(num);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer value : resultList) {
            // 不考虑特殊情况，先挑出在同一位的那些key

            stringBuilder.append(romaStr(value));
        }

        return stringBuilder.toString();
    }


    private String romaStr(int num) {
        if(num == 0){
            return "";
        }

        int choseKey = 0;
        int minValue = Integer.MAX_VALUE;

        for (Integer val : keyList) {
            if (String.valueOf(val).length() == String.valueOf(num).length()) {
                if (num == val) {
                    choseKey = val;
                    break;
                } else if (num < getSPNum(String.valueOf(num).length())) {
                    choseKey = getSPNum(String.valueOf(num).length()) / 4;
                } else if ( num -val > 0 && num -val < minValue) {
                    minValue = num -val;
                    choseKey = val;
                }
            }
        }
        int left = num - choseKey;
        if (left <= 0) {
            return romanMap.get(choseKey);
        }
        return romanMap.get(choseKey) + romaStr(left);
    }

    private int getSPNum(int length) {
        String result = "4";
        for (int i = 1; i < length; i++) {
            result =  result + "0";
        }
        return Integer.parseInt(result);
    }


    public List<Integer> partition(int num) {
        int index = 0;

        String str = String.valueOf(num);
        List<Integer> result = new ArrayList<>();
        while (index < str.length()) {
            int step = 0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.charAt(index));
            while (index + step < str.length() - 1) {
                stringBuilder.append("0");
                step++;
            }
            result.add(Integer.parseInt(stringBuilder.toString()));
            index++;
        }
        return result;
    }


    public static void main(String[] args) {
        IntToRoma intToRoma = new IntToRoma();
        // List<Integer> result = intToRoma.partition(10);
       // System.out.println(result);

        // intToRoma.intToRoman(1994);
       // System.out.println(intToRoma.intToRoman(58));
        System.out.println(intToRoma.intToRoman(10));
        // System.out.println(result);
    }
}
