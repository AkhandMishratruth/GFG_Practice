import java.util.*;
import java.io.*;

public class Knapsack {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), w = in.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for (int i = 0; i < val.length; i++)
            val[i] = in.nextInt();
        for (int j = 0; j < wt.length; j++)
            wt[j] = in.nextInt();
        int[][] ar = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0)
                    ar[i][j] = 0;
                else if (j >= wt[i - 1])
                    ar[i][j] = Math.max(ar[i - 1][j], val[i - 1] + ar[i - 1][j - wt[i - 1]]);
                else
                    ar[i][j] = ar[i - 1][j];
            }
        }
        System.out.println(ar[n][w]);
    }
}