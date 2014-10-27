package leetcode;

/**
 * Created by ray on 10/16/14.
 */
public class Search2DMatrix {

    public int[] convertFrom2DtoArray(int[][] matrix){
        int[] array = new int[matrix.length*matrix[0].length];
        if(matrix == null){
            return array;
        }
        if(matrix.length == 0){
            return array;
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                array[i*matrix[0].length+j] = matrix[i][j];
            }
        }
        return array;
    }

    public boolean binarySearch(int[] arr, int low, int high, int target){
        while(low<=high){
            int mid = (low+high)/2;
            if(target == arr[mid]){
                return true;
            }else if(target < arr[mid]){
                high = mid - 1;
            }else if(target > arr[mid]){
                low = mid + 1;
            }

        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] array = convertFrom2DtoArray(matrix);
        return binarySearch(array,0, array.length-1,target);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] input = new int[][]{{1}};

        Search2DMatrix run = new Search2DMatrix();
        System.out.print(run.searchMatrix(input,2));
    }
}
