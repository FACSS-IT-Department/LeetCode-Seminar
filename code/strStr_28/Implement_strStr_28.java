package leetcode;

public class Implement_strStr_28{

    /**
     Created by Cookies

     time:O(n^2)
     space:O(1)
     **/
    public static int strStr(String haystack, String needle){

        if(needle.length() == 0) return 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++){

            if(haystack.substring(i, i + needle.length()).equals(needle)) return i;

        }
        return -1;

    }

}


/**
 substring()在Java 7 之前是常数复杂度，现在为线性复杂度。
 **/
