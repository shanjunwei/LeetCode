package number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: 罗马数字转整型
 * @author: shan junwei
 * @create: 2020-01-28 09:38
 **/

public class RomeToInt {

    private Map<String, Integer> romanMap = new HashMap<>();


    private void initMap(Map<String, Integer> map) {
        if (map == null) {
            return;
        }
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }


    // 关键在于切词
    public List<String> segment(String str) {
        initMap(romanMap);

        int maxSegLength = 2;
        int index = 0;
        Set<String> set = romanMap.keySet();
        List<String> result = new ArrayList<>();
        while (index < str.length()) {
            // 滑动窗口取词
            int length = maxSegLength;

            // 步长为1
            int step = 1;

            while (length > 0 ) {
                // 取词
                if(index + length > str.length()){
                    length--;
                    continue;
                }
                String seg = str.substring(index, index + length);
                if (set.contains(seg)) {
                    result.add(seg);
                    step = length;
                    length = -1;
                } else {
                    if (length == 1) {
                        result.add(seg);
                    }
                    length--;
                }
            }
            index += step;
        }
        return result;
    }


    public int romanToInt(String s) {
        //  map 初始化
        initMap(romanMap);
        Set<String> set = romanMap.keySet();

        // 考虑特殊情况，对罗马数字进行最大正向匹配切词。取词长度为2

        // 如果不考虑特殊情况
        int result = 0;
        //for (int i = 0; i < s.length(); i++) {
        List<String> stringList = segment(s);
        for (String str : stringList) {
            if (!set.contains(str)) {
                return -1;
            }
            result += romanMap.get(String.valueOf(str));
        }
        return result;
    }


    public static void main(String[] args) {
        RomeToInt romeToInt = new RomeToInt();

      //  System.out.println(romeToInt.romanToInt("MCMXCIV"));

        System.out.println(romeToInt.romanToInt("LVIII"));
        System.out.println(romeToInt.romanToInt("III"));
        System.out.println(romeToInt.romanToInt("IV"));

       // romeToInt.segment("MCMXCIV");
    }


}
