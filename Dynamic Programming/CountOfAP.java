import java.io.*;
import java.util.*;

public class CountOfAP {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=in.nextInt();
        p.println(Counter(ar));
        p.flush();
        p.close();
    }
    static int Counter(int[] ar) {
        int MAX = 1000000;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            min = Math.min(min, ar[i]);
            max = Math.max(max, ar[i]);
        }
        int[] dp = new int[ar.length];
        int[] sum = new int[MAX];
        int ans=ar.length + 1;
        for (int d = min - max; d <= max - min; d++) {
            Arrays.fill(sum, 0);
            for(int i=0;i<ar.length;i++){
                dp[i] = 1;
                if(ar[i]-d>=1 && ar[i] - d<=1000000)
                    dp[i]+=sum[ar[i]-d];
                ans+=dp[i]-1;
                sum[ar[i]]+=dp[i];
            }
        }
        return ans;
    }
}