import java.util.*;
import java.io.*;

public class MobileNumericKeypad {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int[][] keypad = {{1,2,3}, {4,5,6}, {7,8,9}, {11, 0, 12}};
        int N = in.nextInt(), num, r, c,nextNum;
        int[][] dp = new int[10][N];
        for (int i = 0; i < 10; i++)
            dp[i][0] = 1;
        int[] row = {0,-1,0,1, 0};
        int[] col = {0, 0,1,0,-1};
        for (int n = 1; n < N; n++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    num = keypad[i][j];
                    for (int move=0;move<5; move++){
                        r = i + row[move];
                        c = j + col[move];
                        if(r>=0 && r<4 && c>=0 && c<3 && keypad[r][c]!=11 && keypad[r][c]!=12 && num != 12 && num!=11){
                            nextNum = keypad[r][c];
                            dp[num][n] += dp[nextNum][n-1];
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum += dp[i][N - 1];
        System.out.println(sum);
    }
}