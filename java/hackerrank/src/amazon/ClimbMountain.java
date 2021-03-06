package amazon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by ray on 10/10/14.
 */
class Mountain{
    int X1 = 0;
    int X2 = 0;
    int Height = 0;
}

public class ClimbMountain {

    private static Mountain[] mountains;

    public static void bubbleSort(Mountain[] array){
        Mountain tmp = new Mountain();
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j].X1 < array[j-1].X1){
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args){
        try{
            //read input data
            readInputData();
            //sort mountains by X1 with bubbleSort, Merge or Quick Sort would be better.
            bubbleSort(mountains);
            System.out.print(caculateDistance());
        }catch (IOException e){
            System.out.print("IOException!");
        }
    }

    private static int caculateDistance() {
        int ans = 0;
        for (int i = 1; i < mountains.length; i++) {
            //Intersection & >= Height of previous mount
            if(mountains[i].X1 <= mountains[i -1].X2 && mountains[i].Height >= mountains[i-1].Height){
                ans += mountains[i].X1 - mountains[i-1].X1 + Math.abs(mountains[i].Height - mountains[i-1].Height);
            }
            //Intersection & < Height of previous mount
            else if(mountains[i].X1 <= mountains[i -1].X2 && mountains[i].Height < mountains[i-1].Height){
                ans += mountains[i].X1 - mountains[i-1].X1;
            }
            //No Intersection
            else{
                ans += mountains[i].X1 - mountains[i-1].X1 + mountains[i].Height + mountains[i-1].Height;
            }
        }
        //Plus the final Mountain Top and Right Cliff
        ans += mountains[mountains.length-1].X2 - mountains[mountains.length-1].X1 + mountains[mountains.length-1].Height;
        return ans;
    }

    private static void readInputData() throws IOException {
        FileInputStream fs = new FileInputStream("./src/amazon/CMtest1.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(fs, "utf-8"));

        int N = Integer.parseInt(in.readLine());
        mountains = new Mountain[N+1];
        //treat (0.0) as a start mountain..
        mountains[0] = new Mountain();

        for (int i = 1; i < N+1; i++) {
            StringTokenizer tok = new StringTokenizer(in.readLine(), ",");
            int token1 = Integer.parseInt(tok.nextToken());
            int token2 = Integer.parseInt(tok.nextToken());
            int token3 = Integer.parseInt(tok.nextToken());
            mountains[i] = new Mountain();
            mountains[i].X1 = token1 < token2?token1:token2;
            mountains[i].X2 = token1 < token2?token2:token1;
            mountains[i].Height = token3;
        }
    }

}