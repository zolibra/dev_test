package Google;

/**
 * Created by ray on 10/23/14.
 */

public class Substring {
    public boolean isSubstring(char[] src, char[] target){
        if(src == null||target==null||src.length == 0||target.length ==0){
            return false;
        }

        for (int i = 0; i < src.length; i++) {
            boolean noMatch = false;
            for (int j = 0; j < target.length; j++) {
                if(src[i+j] != target[j]){
                    noMatch = true;
                    break;
                }
            }
            if(!noMatch)return true;
        }
        return false;
    }
    public static void main(String[] args) {
        char[] src = {'a','b','c','d'};
        char[] target = {'b','d'};
        System.out.print(new Substring().isSubstring(src,target));
        
    }
}
