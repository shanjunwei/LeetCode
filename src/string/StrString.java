package string;

import org.junit.Assert;

/**
 * @description: 字符串匹配
 * @author: shan junwei
 * @create: 2019-12-21 17:20
 **/

/*
实现 strStr() 函数。

    给定一个 haystack 字符串和一个 needle 字符串，
    在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
    如果不存在，则返回  -1。

        示例 1:

        输入: haystack = "hello", needle = "ll"
        输出: 2
        示例 2:

        输入: haystack = "aaaaa", needle = "bba"
        输出: -1
*/


public class StrString {

    public int strStr(String haystack, String needle) {
        // 先实现暴力匹配,再考虑kmp算法优化
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        if (needleArray.length == 0 && needleArray.length == 0) {
            return 0;
        }

        if (needleArray.length == 0 || needleArray.length == 0) {
            return -1;
        }

        if (needleArray.length > haystackArray.length) {
            return -1;
        }
        int index = 0;
        while (index < haystackArray.length) {
            int i = index;
            int j = 0;

            while (i < haystackArray.length && j < needleArray.length && haystackArray[i] == needleArray[j]) {
                i++;
                j++;
            }
            if (j == needleArray.length) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }


    /**
     * 两个字符串进行比较
     *
     * @param haystack
     * @param needle
     * @return
     */
    public boolean strMatch(String haystack, String needle) {
        if (haystack.length() != needle.length()) {
            return false;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 两个字符串进行匹配，递归方法
     *
     * @param haystack
     * @param needle
     * @return
     */

    public boolean strMatchRecursive(String haystack, String needle) {
        if (haystack.length() != needle.length()) {
            return false;
        }
        if ("".equals(haystack)) {
            return "".equals(needle);
        }
        if (haystack.charAt(0) != needle.charAt(0)) {
            return false;
        } else {
            return true && strMatchRecursive(haystack.substring(1), needle.substring(1));
        }
    }


    /**
     * 两个字符串进行匹配，递归加上点 .
     *
     * @param haystack
     * @param pattern
     * @return
     */

    public boolean strMatchHandlePoint(String haystack, String pattern) {
        if (haystack.length() != pattern.length()) {
            return false;
        }
        if ("".equals(haystack)) {
            return "".equals(pattern);
        }
        if (('.'!=pattern.charAt(0)) && haystack.charAt(0) != pattern.charAt(0)) {
            return false;
        } else {
            return true && strMatchHandlePoint(haystack.substring(1), pattern.substring(1));
        }
    }

    /**
     * 两个字符串进行匹配，递归加上点 .
     *   再加上 * 号
     * @param str
     * @param pattern
     * @return
     */
    public boolean strMatchHandlePointAndStar(String str, String pattern) {
        if ("".equals(str) ) {
            // 递归终止条件
            return "".equals(pattern);
        }
        if("".equals(pattern)){
            return  "".equals(str);
        }

        boolean firstMatch =  pattern.charAt(0)== '.' || pattern.charAt(0) == '*' || pattern.charAt(0)== str.charAt(0);

         if('*'== pattern.charAt(0) && pattern.length()>= 2){
            // 如果匹配到了*
            String oneTime =  str.substring(1);
            // 不管* 匹配多少次，当前只有两个选择，匹配0次,匹配1次
            // 匹配0次，就是pattern跳过*
            // 匹配1次，就是pattern不动,前面str向前走一步
            return  strMatchHandlePointAndStar(str,pattern.substring(2)) ||
                    (firstMatch && strMatchHandlePointAndStar(oneTime,pattern));
        } else {
            return firstMatch &&  strMatchHandlePointAndStar(str.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        StrString strString = new StrString();

        String test = "hello,ll";
        String[] array = test.split(",");
        int ret = strString.strStr(array[0], array[1]);
        Assert.assertEquals(2, ret);

        test = "hello,lo";
        array = test.split(",");
        ret = strString.strStr(array[0], array[1]);
        Assert.assertEquals(3, ret);

        test = "hello,he";
        array = test.split(",");
        ret = strString.strStr(array[0], array[1]);
        Assert.assertEquals(0, ret);

        test = "hello,o";
        array = test.split(",");
        ret = strString.strStr(array[0], array[1]);
        Assert.assertEquals(4, ret);


        boolean result = strString.strMatchRecursive("shan", "shakn");
        Assert.assertEquals(false, result);


        result = strString.strMatchRecursive("shan", "shan");
        Assert.assertEquals(true, result);

        result =  strString.strMatchHandlePoint("shanjunwei","shan.unwei");
        Assert.assertEquals(true, result);

        result =  strString.strMatchHandlePointAndStar("aab","c*a*b");
        Assert.assertEquals(false, result);
    }

}
