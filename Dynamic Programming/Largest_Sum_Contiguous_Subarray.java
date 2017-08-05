import java.util.*;
import java.io.*;

public class Largest_Sum_Contiguous_Subarray {
    public static void main(String args[]) throws Exception {
        PrintWriter p = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
            sum = Math.max(sum + ar[i], ar[i]);
            max = Math.max(max, sum);
        }
        p.println(max);
        p.flush();
        p.close();
    }
}