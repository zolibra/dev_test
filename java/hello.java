public class hello{
 public static void main(String args[]){

  String [] tab = {"A","B","C","D","E"};
  int n = 9;
  int m = 0;
  int k = 0;
  String[][] a = new String[n][n];
  String[][] b = new String[n][n];
  if(n %2 ==0){
   m = n;
  }else{
   m = n/2 +1;
  }

  for(int i = 0;i<m;i++){
   for(int j =i;j<n-i;j++){
    b[i][j] = tab[i];
   }
   for(int j = i+1;j<n-i;j++){
    b[j][n-i-1]=tab[i];
   }
   for(int j = n-i-2;j>=i;j--){
    b[n-i-1][j] = tab[i];
   }
   for(int j = n-i-2;j>=i+1;j--){
    b[j][i] = tab[i];
   }
  }
  for(int i = 0;i<b.length;i++){
   for(int j = 0;j<b.length;j++){
       
    
    System.out.print(b[i][j] + " ");
   }
   System.out.println();
  }
  System.exit(0);
  
 }
}