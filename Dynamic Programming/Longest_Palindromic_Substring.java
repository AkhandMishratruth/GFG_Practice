import java.util.*;
import java.io.*;

public class Longest_Palindromic_Substring {
    public static void main(String args[]) throws Exception {
        PrintWriter p = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int j, max_len=0, n = str.length();
        boolean[][] ar = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            ar[i][i] = true;
            max_len = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                ar[i][i + 1] = true;
                max_len = 2;
            }
        }
        for (int l = 3; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                j = i + l - 1;
                if (ar[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    ar[i][j] = true;
                    if (max_len < l)
                        max_len = l;
                }
            }
        }
        p.println(max_len);
        p.flush();
        p.close();
    }
}