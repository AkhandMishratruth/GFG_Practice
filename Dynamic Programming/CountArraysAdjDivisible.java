import java.util.*;
import java.io.*;

public class CountArraysAdjDivisible {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] dp = new int[n+1][m+1];
        LinkedList<Integer>[] mul = new LinkedList[m+1];
        LinkedList<Integer>[] div = new LinkedList[m+1];
        for(int i =0;i<=m;i++){
            mul[i]=new LinkedList<Integer>();
            div[i]=new LinkedList<Integer>();
        }
        
        for(int i =1;i<=m;i++){
            for(int j=2*i;j<=m;j+=i){
                mul[i].push(j);
                div[j].push(i);
            }
            div[i].push(i);
        }
        for(int i =1;i<=m;i++)
            dp[1][i]=1;

        Iterator it;
        for(int i =2;i<=n;i++){
            for(int j=1;j<=m;j++){
                it = div[j].iterator();
                while(it.hasNext())
                    dp[i][j]+=dp[i-1][(int)it.next()];
                it = mul[j].iterator();
                while(it.hasNext())
                    dp[i][j]+=dp[i-1][(int)it.next()];
            }
        }
        int ans=0;
        for(int i =1;i<=m;i++)
            ans+=dp[n][i];
        System.out.println(ans);
    }
}
