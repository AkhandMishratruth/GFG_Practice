import java.util.*;
import java.io.*;

public class Fibonacci {
    public static void main(String args[]) throws Exception {
        PrintWriter p = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fibo(n));
        p.flush();
        p.close();
    }

    static int fibo(int n){
        int[][] f = new int[][]{{1,1},{1,0}};
        if(n==0)
            return 0;
        power(f,n-1);
        return f[0][0];
    }
    static void power(int f[][], int n){
        if(n==0||n==1)
            return;
        int[][] m = new int[][]{{1,1},{1,0}};
        power(f,n/2);
        multiply(f,f);
        if(n%2!=0)
            multiply(f,m);

    }
    static void multiply(int a[][], int b[][]){
        int p,q,r,s;
        p = a[0][0]*b[0][0] + a[0][1]*b[1][0];
        q = a[0][0]*b[0][1] + a[0][1]*b[1][1];
        r = a[1][0]*b[0][0] + a[1][1]*b[1][0];
        s = a[1][0]*b[0][1] + a[1][1]*b[1][1];
        a[0][0] = p;
        a[0][1] = q;
        a[1][0] = r;
        a[1][1] = s;
    }
}