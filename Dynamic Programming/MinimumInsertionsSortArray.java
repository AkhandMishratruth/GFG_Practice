import java.io.*;
import java.util.*;

public class MinimumInsertionsSortArray {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=in.nextInt();
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int max=1;
        for(int i =1;i<n;i++){
            for(int j=0;j<i;j++){
                if(ar[i]>ar[j])
                    lis[i]=Math.max(lis[i], lis[j]+1);
            }
            max = Math.max(max, lis[i]);
        }
        System.out.println(n-max);
    }
}