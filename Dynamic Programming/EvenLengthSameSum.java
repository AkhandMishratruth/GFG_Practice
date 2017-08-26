import java.util.*;
import java.io.*;

public class EvenLengthSameSum {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int[] ar = new int[n];
        for(int i = 0;i<n;i++)
            ar[i]=in.nextInt();
        for(int i =1;i<n;i++)
            ar[i]+=ar[i-1];
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n ; j++) {
                if(i!=0)
                    dp[i][j] = ar[j]-ar[i-1];
                else
                    dp[i][j]=ar[j];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int length = 2;length<=n;length+=2){
            for(int start = 0;start<n-length+1;start++){
                if(dp[start][start-1+length/2]==dp[start+length/2][start+length-1])
                    max= Math.max(max, length);
            }
        }
        System.out.println(max);
    }
}