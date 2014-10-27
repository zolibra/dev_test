package leetcode;

/**
 * Created by ray on 6/20/14.
 */
public class testRevertString {
    //效率问题，避免使用正则，如果数据不大，可以用split，但是1000以后呈指数级上升
    //详情阅读 http://blog.csdn.net/songylwq/article/details/9016609
    private static String revertString1(String s){
        if (s == null){
            return "";
        }
        s.trim();
        if (s == null){
            return "";
        }

        if (s == ""){
            return "";
        }

            StringBuffer newStr = new StringBuffer();
            String s2 = s.replaceAll(" +" ," ");
            String[] newArray = s2.split(" ");
            for (int i = newArray.length -1 ; i >= 0 ;i--){
                newStr.append(newArray[i]);
            newStr.append(" ");
        }

        return newStr.toString().trim();
    }
    //leetcode solution, did not use split
    public static String revertString2(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                String s  = new String();
                s.to
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }

    public static void main(String [] args){

        String[] testStrings = {"hello this is hui   haha" ,
                "  this is    hui  ! ",
                ""};
        for (String str:testStrings){
                    System.out.println(revertString2(str));
        }


    }

}
