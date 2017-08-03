import java.util.*;
import java.io.*;

public class Coin_Change {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), coin = in.nextInt();
        int[] table = new int[n + 1];
        int[] coins = new int[coin];
        table[0] = 1;
        for (int i = 0; i < coin; i++)
            coins[i] = in.nextInt();
        for (int i = 0; i < coin; i++)
            for (int j = coins[i]; j <= n; j++)
                table[j] += table[j - coins[i]];
        System.out.println(table[n]);
    }
}