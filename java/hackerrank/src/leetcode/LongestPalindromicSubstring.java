package leetcode;

import java.nio.charset.Charset;
import java.util.HashSet;

/**
 * Created by ray on 10/16/14.
 */

/*
http://blog.csdn.net/u014779993/article/details/24349833
 */
public class LongestPalindromicSubstring {

    public String expendFromCenter(String s , int left, int right){
        int len = s.length();
        while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    public String longestPalindrome(String s) {
        if(s == null|s.length() <=1)return s;
        String longest = s.substring(0,1);
        for (int i = 0; i < s.length()-1; i++) {
            String p1 = expendFromCenter(s, i , i);//aba case
            if(p1.length() > longest.length()){
                longest = p1;
            }

            String p2 = expendFromCenter(s, i, i+1);//aa case
            if( p2.length() > longest.length()){
                longest = p2;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.print(lps.longestPalindrome("abcdcbaabaaabac"));

    }
}
