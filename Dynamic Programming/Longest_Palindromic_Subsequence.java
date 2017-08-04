import java.util.*;
import java.io.*;

public class Longest_Palindromic_Subsequence {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        int end,n = str.length();
        int[][] ar = new int[n][n];
        for(int i=0;i<n;i++)
            ar[i][i]=1;
        for(int l = 2;l<=n;l++){
            for(int start = 0;start<n-l+1;start++){
                end = start + l - 1;
                if(str.charAt(start)==str.charAt(end) && l==2)
                    ar[start][end]=2;
                else if(str.charAt(start)==str.charAt(end))
                    ar[start][end]=ar[start+1][end-1]+2;
                else
                    ar[start][end]=Math.max(ar[start+1][end],ar[start][end-1]);
            }
        }
        System.out.println(ar[0][n-1]);
    }
}