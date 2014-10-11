package Google;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Created by ray on 10/9/14.
 */
/*
eg. this is hui --> siht si iuh
 */
public class ReverseWordsInString {
    public static void main(String[] args) throws Exception {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] array = in.readLine().split(" ");
            for (int i = 0; i < array.length; i++) {

                System.out.print(reverse(array[i]) + " ");

            }

        }
    public static String reverse(String str){
        char[] array = str.toCharArray();
        char tmp;
        for (int i = 0; i < array.length/2; i++) {
            tmp = array[i];
            array[i] = array[array.length -1 - i];
            array[array.length - 1 - i] = tmp;
        }
        //Notice that using toString will cause unexpected result
        return  String.valueOf(array);
    }
}
