import java.util.*;
import java.io.*;

public class Floyd_Warshall_Algorithm {
    public static void main(String args[]) throws Exception {
        PrintWriter p = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[][] ar = new int[n][n]
        for(int i=0;i<n;i++)
            for(int j =0;j<n;j++)
                ar[i][j]=in.nextInt();
        int[][] dist = ar.clone();
        for(int k=0;i<n;k++){
            for(int i =0;i<n;i++){
                for(int j =0;j<n;j++){
                    if(dist[i][k]+dist[k][j]<dist[i][j])
                        dist[i][j]=dist[i][k]+dist[k][j];
                }
            }
        }
        p.flush();
        p.close();
    }
}
