import java.util.*;

/**
 * Created by ray on 10/25/14.
 */
public class QuickSort {


//2 8 7 1 3 5 6 4 主元为A[r] = 4 see introduction to algorithsm
    static int partition1(int[]ar, int p, int r){
        int x = ar[r];
        int i = p-1;
        for(int j = p; j<r;j++){
            if(ar[j]<=x){
                i++;
                //swap
                int tmp = ar[i];
                ar[i] = ar[j];
                ar[j] = tmp;
            }
        }
        //swap
        int tmp = ar[r];
        ar[r] = ar[i+1];
        ar[i+1] = tmp;
        return i+1;
    }
    //5 8 1 3 7 9 2 主元为A[p] = 5
    static int partition2(int[]ar, int p, int r){
        int x = ar[p];
        int i = p;
        for(int j = p+1; j<=r;j++){
            if(ar[j]<=x){
                i++;
                //swap
                int tmp = ar[i];
                ar[i] = ar[j];
                ar[j] = tmp;
            }
        }
        //swap
        int tmp = ar[p];
        ar[p] = ar[i];
        ar[i] = tmp;
        return i;
    }
    static void realQuickSort(int[] ar, int p, int r){
        if(p<r){
            int q = partition2(ar,p,r);
            realQuickSort(ar,p,q-1);
            realQuickSort(ar,q+1,r);
            for(int i=p;i<=r;i++)
                System.out.print(ar[i] + " ");
            System.out.println();
        }
    }



    static int hackerrankPartition(int[] ar, int p, int r) {
        int x = ar[p];
        List<Integer> smaller = new ArrayList<Integer>();
        List<Integer> bigger = new ArrayList<Integer>();

        for(int j = p+1; j<=r;j++){
            if(ar[j] <= x){
                smaller.add(ar[j]);
            }else{
                bigger.add(ar[j]);
            }
        }
        int j;
        for(j = 0; j< smaller.size();j++){
            ar[p+j] = (Integer)smaller.toArray()[j];
        }
        ar[p+smaller.size()] = x;
        for(j = 0; j < bigger.size();j++){
            ar[smaller.size()+p+j+1] = (Integer)bigger.toArray()[j];
        }
        return p+smaller.size();
    }
    static void hackerrankQuickSort(int[] ar, int p, int r){
        if(p<r){
            int q = hackerrankPartition(ar,p,r);
            hackerrankQuickSort(ar,p,q-1);
            hackerrankQuickSort(ar,q+1,r);
            printArray(ar, p, r);
        }
    }

    static void quickSort(int[] ar) {
//        realQuickSort(ar, 0 ,ar.length-1);
        hackerrankQuickSort(ar, 0 ,ar.length-1);
    }

    static void printArray(int[] ar, int p, int r) {
        for(int i = p; i <=r;i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        quickSort(ar);
    }
}
