import java.util.*;
import java.io.*;

public class Longest_Bitonic_Subsequence {
    public static void main(String args[]) throws Exception {
        PrintWriter p = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i =0;i<n;i++)
            ar[i]=in.nextInt();
        int[] lis = new int[n];
        int[] lds = new int[n];
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);
        for(int i =1;i<ar.length;i++){
            for(int j=0;j<i;j++){
                if(ar[j]<ar[i] && lis[j] + 1 > lis[i])
                    lis[i] = lis[j] + 1;
            }
        }
        for(int i =ar.length-2;i>-1;i--){
            for(int j=ar.length-1;j>i;j--){
                if(ar[j]<ar[i] && lds[j] + 1 > lds[i])
                    lds[i] = lds[j] + 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<ar.length;i++)
            max = Math.max(max, lis[i]+lds[i]);
        p.println(max-1);
        p.flush();
        p.close();
    }
}