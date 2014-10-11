package amazon;

import java.io.*;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ray on 10/9/14.
 */
/*
3 3
1 2 3
4 5 6
7 8 9

5 3
1 2 3 4 5 6
7 8 9 10 11 12
6 5 4 3 2 1
 */
public class MatrixRoute {
    public static void main(String[] args) {
        try {
            FileInputStream fs = new FileInputStream("./src/amazon/test2.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(fs,"utf-8"));
            String[] demension = in.readLine().split(" ");
            int col = Integer.parseInt(demension[0]);
            int row = Integer.parseInt(demension[1]);
            int[][] matrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                String[] array_row = in.readLine().split(" ");
                System.out.println();
                for (int j = 0; j < col; j++) {
                    System.out.print(Integer.parseInt(array_row[j]) + " ");
                    matrix[i][j] = Integer.parseInt(array_row[j]);
                }
            }
            System.out.println();
            System.out.println("----------------");
            System.out.print(matrixRoute(matrix,row,col));

        }catch (IOException e){

        }
    }
    public static StringBuffer matrixRoute(int[][] mx, int row, int col){
        StringBuffer result = new StringBuffer();
        //print right
        int index_x = 0 , index_y = 0;
        for (int i = 0; i < col-1; i++) {
            result.append(mx[0][index_x++] + " ");
        }
        //print left down
        int cross = col < row ? col :row;
        for (int i = 0; i < cross ; i++) {
            result.append(mx[index_y++][index_x--] + " ");
        }
        //maybe print left
        if (row > 1){
            for (int i = index_x; i >= 0; i--) {
                result.append(mx[row - 1][index_x--] + " ");
            }
        }
        //print top
        index_y--;
        for (int i = index_y - 1; i > 0; i--) {
            result.append(mx[--index_y][0] + " ");

        }

        return result;
    }
}
