public class test{
 public static void main(String args[]){

  String [] tab = {"A","B","C","D","E"};
  int n = 3;
  int m = 2*n -1;
  int k = 0;
  String[][] a = new String[n][n];

  for (int i = 0; i < m; i++ ) {
    for (int j = 0; j < m ; j++) {
          a[i][j] = tab[n-i-1];
    }
  }

    for(int i = 0;i<a.length;i++){
   for(int j = 0;j<a.length;j++){
       
    
    System.out.print(a[i][j] + " ");
   }
   System.out.println();
  }
}
}