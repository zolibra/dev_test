package com.mytest;

/**
 * Created by ray on 7/5/14.
 */
public class testRoman2Int {
    public static int mapping(char c){
                 switch (c){
                 case 'I': return 1;
                     case 'V': return 5;
                     case 'X': return 10;
                     case 'L': return 50;
                     case 'C': return 100;
                     case 'D': return 500;
                     case 'M': return 1000;
                 default: return 0;
             }
    }
    public static int romantoint( String s ){
        int sum = 0;
        for (int i = 0; i < s.length() ;i++){
            if (i > 0 && mapping(s.charAt(i)) >mapping(s.charAt(i - 1)) ){
                sum += mapping(s.charAt(i)) - 2*mapping(s.charAt(i-1));
    }else{
        sum += mapping(s.charAt(i));
    }
}
        return sum;
    }

    public static void main(String[] args){
        String s = "MCMXCVI";
        System.out.println(romantoint(s));
    }
}
