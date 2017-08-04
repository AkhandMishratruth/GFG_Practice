import java.util.*;
import java.io.*;

public class Binomial_Coefficient {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), r=in.nextInt();
        int[][] ar = new int[n+1][r+1];
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar[0].length;j++){
                if(i==0)
                    ar[i][j]=0;
                else if(j==0 || i==j)
                    ar[i][j]=1;
                else {
                    ar[i][j]=ar[i-1][j]+ar[i-1][j-1];
                }
            }
        }
        System.out.println(ar[n][r]);
    }
}