import java.util.*;
import java.io.*;

public class Cutting_Rod {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int max,n = in.nextInt();
        int[] cost = new int[n];
        for(int i=0;i<n;i++)
            cost[i]=in.nextInt();
        int[] value = new int[n+1];
        value[0]=0;
        for(int i=1;i<=n;i++){
            max=Integer.MIN_VALUE;
            for(int j=1;j<=i;j++)
                max = Math.max(max, cost[j-1]+value[i-j]);
            value[i]=max;
        }
        System.out.println(value[n]);
    }
}