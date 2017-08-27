import java.util.*;
import java.io.*;

public class MaxPointGridTwoTraversal {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m  = in.nextInt();
        int[][] ar = new int[n][m];
        for(int i =0;i<n;i++)
            for(int j=0;j<m;j++)
                ar[i][j]=in.nextInt();
        int[][][] dp = new int[n][m][m];
        for(int i=0;i<n;i++ )
            for(int j =0;j<m;j++)
                for(int k = 0;k<m;k++)
                    dp[i][j][k]=-1;

        System.out.println(maxGrid(ar, dp, 0, 0, m-1, n, m));
    }
    static int maxGrid(int[][] ar, int[][][] dp, int x, int y1, int y2, int n, int m){
        if(!isValid(x,y1,y2,n,m))
            return Integer.MIN_VALUE;
        if(x==n-1 && y1==0 && y2==m-1)
            return (y1==y2) ? ar[x][y1] : ar[x][y1] + ar[x][y2];
        int ans = Integer.MIN_VALUE;
        int temp = (y1==y2) ? ar[x][y1] : ar[x][y1] + ar[x][y2];
        ans = Math.max(ans, temp + maxGrid(ar, dp, x+1, y1-1,y2-1, n, m));
        ans = Math.max(ans, temp + maxGrid(ar, dp, x+1, y1-1,y2, n, m));
        ans = Math.max(ans, temp + maxGrid(ar, dp, x+1, y1-1,y2+1, n, m));

        ans = Math.max(ans, temp + maxGrid(ar, dp, x+1, y1,y2-1, n, m));
        ans = Math.max(ans, temp + maxGrid(ar, dp, x+1, y1,y2, n, m));
        ans = Math.max(ans, temp + maxGrid(ar, dp, x+1, y1,y2+1, n, m));

        ans = Math.max(ans, temp + maxGrid(ar, dp, x+1, y1+1,y2-1, n, m));
        ans = Math.max(ans, temp + maxGrid(ar, dp, x+1, y1+1,y2, n, m));
        ans = Math.max(ans, temp + maxGrid(ar, dp, x+1, y1+1,y2+1, n, m));

        dp[x][y1][y2]=ans;
        return ans;
    }
    static boolean isValid(int x, int y1, int y2, int n, int m){
        return (x>=0 && x<n && y1>=0 && y1<m && y2>=0 && y2<m);
    }
}