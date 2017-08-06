import java.util.*;
import java.io.*;

public class Reach_score {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] point = new int[]{3, 5, 10};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 0;i<3;i++){
            for(int j = point[i];j<n+1;j++){
                dp[j] += dp[j-point[i]];
            }
        }
        System.out.println(dp[n]);
    }
}