import java.io.*;
import java.util.*;

public class TempleOfferings {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=in.nextInt();
        p.println(mandir(ar));
        p.flush();
        p.close();
    }
    static int mandir(int[] ar){
        DP[] dp = new DP[ar.length];
        for(int i=0;i<ar.length;i++)
            dp[i]=new DP(-1,-1);
        dp[0].L=1;
        for(int i=1;i<ar.length;i++){
            if(ar[i-1]<ar[i])
                dp[i].L=dp[i-1].L+1;
            else
                dp[i].L=1;
        }
        dp[ar.length-1].R=1;
        for(int i=ar.length-2;i>=0;i--){
            if(ar[i]>ar[i+1])
                dp[i].R=dp[i+1].R+1;
            else
                dp[i].R=1;
        }
        int sum=0;
        for(int i=0;i<ar.length;i++) {

            sum += Math.max(dp[i].L, dp[i].R);
        }
        return sum;
    }
}
class DP{
    int L, R;
    DP(int l, int r){
        L=l;
        R=r;
    }
}