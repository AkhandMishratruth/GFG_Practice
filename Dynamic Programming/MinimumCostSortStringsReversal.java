import java.util.*;
import java.io.*;

public class MinimumCostSortStringsReversal {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //in.nextLine();
        String[] ar = new String[n];
        int[] cost = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=in.next();
        for(int i=0;i<n;i++)
            cost[i]=in.nextInt();

        String[] rev = new String[n];
        for(int i =0;i<n;i++)
            rev[i] = reverse(ar[i]);
        int[][] dp = new int[n][2];
        dp[0][0]=0;dp[0][1]=cost[0];
        String curStr;
        int curCost;
        for(int i =1;i<n;i++){
            for(int j = 0;j<2;j++){
                curStr = (j==0) ? ar[i]:rev[i];
                curCost = (j==0)?0:cost[i];
                dp[i][j]=Integer.MAX_VALUE;
                if(curStr.compareTo(ar[i-1])>=0)
                    dp[i][j]=Math.min(dp[i][j], dp[i-1][0]+curCost);
                if(curStr.compareTo(rev[i-1])>=0)
                    dp[i][j]=Math.min(dp[i][j], dp[i-1][1]+curCost);
            }
        }
        System.out.println(Math.min(dp[n-1][0],dp[n-1][1]));
    }
    static String reverse(String st){
        StringBuilder str = new StringBuilder(st);
        str = str.reverse();
        return str.toString();
    }
}