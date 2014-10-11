import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ray on 10/9/14.
 */
/*
20
0 ab
6 cd
0 ef
6 gh
4 ij
0 ab
6 cd
0 ef
6 gh
0 ij
4 that
3 be
0 to
1 be
5 question
1 or
2 not
4 is
2 to
4 the
 */
public class CountingSort {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuffer[] array = new StringBuffer[100];
        for(int i = 0; i < 100; i++) {
            array[i] = new StringBuffer();
        }
        for(int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            int v = Integer.parseInt(line[0]);
            String s = line[1];
            array[v].append(i < n / 2 ? "-" : s).append(" ");
        }
        for(int i = 0; i < 100; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
