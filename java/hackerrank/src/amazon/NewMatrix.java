package amazon;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NewMatrix {
    //routeX = 1 routeY = 0 means right while routeX = -1 routeY = 1 means left down
    static int[] nextRouteX = {1, -1, -1, 0};
    static int[] nextRouteY = {0, 1, 0, -1};

    public static int[] convertMatrix(int width, int height, int[] matrix){
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] passby_recorder = new boolean[matrix.length];//record passed by element
        Arrays.fill(passby_recorder, false);
        passby_recorder[0] = true;
        int current_x = 0, current_y = 0, next_x, next_y;
        Boolean done = false;
        result.add(matrix[0]);
        while (!done)
        {
            done = true;
            for (int i = 0; i < nextRouteX.length; i++)
            {
                while(true)
                {
                    next_x = current_x + nextRouteX[i];
                    next_y = current_y + nextRouteY[i];
                    int next_index = matrix2arrayIndex(next_x, next_y, width, height);
                    if (isStillInMatrix(next_x, next_y, width, height) && !passby_recorder[next_index])//try to go to the next point
                    {
                        passby_recorder[next_index] = true;
                        result.add(matrix[next_index]);
                        done = false;
                        current_x = next_x;
                        current_y = next_y;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }

        int[] ret = new int[result.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = result.get(i).intValue();
        }
        return ret;
    }

    //if in the matrix
    public static boolean isStillInMatrix(int x,int y, int width, int height){
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    public static int matrix2arrayIndex(int x,int y, int width, int height)
    {
        return y * width + x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;
        int _width;
        _width = in.nextInt();

        int _height;
        _height = in.nextInt();


        int[] _matrix = new int[_width * _height];
        int _matrix_item;
        for(int _matrix_i = 0; _matrix_i < _width * _height; _matrix_i++) {
            _matrix_item = in.nextInt();
            _matrix[_matrix_i] = _matrix_item;
        }

        res = convertMatrix(_width, _height, _matrix);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.print(res[res_i]);
            System.out.print(" ");
        }

    }
}