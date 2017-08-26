import java.util.*;
import java.io.*;

public class SpiralMatrix {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt(), m = in.nextInt();
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                mat[i][j]=in.nextInt();
        int k=0,l=0;
        while(k<n && l<m){
            for(int i=l;i<m;i++){
                System.out.print(mat[k][i]+" ");
            }
            k++;
            for(int i =k;i<n;i++){
                System.out.print(mat[i][m-1]+" ");
            }
            l++;
            m--;
            for(int i=m-1;i>=l-1;i--){
                System.out.print(mat[n-1][i]+" ");
            }
            n--;
            for(int i =n-1;i>=k;i--){
                System.out.print(mat[i][k-1]+" ");
            }
        }
    }
}