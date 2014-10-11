package leetcode;

/**
 * Created by ray on 6/20/14.
 */
public class testRevertString {

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

    public static void main(String [] args){

        String[] testStrings = {"hello this is hui   haha" ,
                "  this is    hui  ! ",
                ""};
        for (String str:testStrings){
                    System.out.println(revertString1(str));
        }


    }

}
