package leetcode;

/**
 Created by Cookies
 **/
// case:"edwardshi", "edward","edwar","edwardshidd"
// time: O(n*l)
// spac: O(1)

public class longestCommonPrefix_14{

    public static String longestCommonPrefix_14(String[] strs){
        if(strs == null || strs.length == 0) return " ";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(res) != 0){
                res = res.substring(0,res.length() - 1);
            }
//            int j = strs[i].indexOf(res);
//            System.out.println(j);
        }

        return res;
    }

}

/**
 indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 **/
/**
 public String substring(int beginIndex)返回字符串
 public String substring(int beginIndex, int endIndex)返回字符串 左闭合右开区间，
 **/
