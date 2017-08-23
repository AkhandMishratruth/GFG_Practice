import java.util.*;
import java.io.*;

public class MinimumSquareSum {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i =4;i<=n;i++){
            dp[i]=i;
            for(int x=1;x<=i;x++) {
                int temp = x*x;
                if (temp > i )
                    break;
                else
                    dp[i]=Math.min(dp[i],1 + dp[i-temp]);
            }
        }
        System.out.println(dp[n]);
    }
}