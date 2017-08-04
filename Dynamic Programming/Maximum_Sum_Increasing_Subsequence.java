import java.util.*;
import java.io.*;

public class Maximum_Sum_Increasing_Subsequence {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=in.nextInt();
        int max=ar[0];
        int[] mis = new int[n];
        mis[0]=ar[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++)
                if(ar[i]>ar[j] && mis[j]+ar[i]>mis[i])
                    mis[i]=mis[j]+ar[i];
            max=Math.max(max,mis[i]);
        }
        System.out.println(max);
    }
}