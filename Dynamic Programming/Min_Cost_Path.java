import java.util.*;
import java.io.*;

public class Min_Cost_Path {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();

        int[][] mat = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j]=in.nextInt();

            }
        }
        for(int i=1;i<mat.length;i++){
            for(int j=1;j<mat[0].length;j++){
                mat[i][i]=mat[i][j]+Math.min(mat[i-1][j],Math.min(mat[i][j-1],mat[i-1][j-1]));
            }
        }
        System.out.println(mat[mat.length-1][mat[0].length-1]);

    }
}