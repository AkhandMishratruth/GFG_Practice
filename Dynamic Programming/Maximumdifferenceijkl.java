import java.io.*;
import java.util.*;

public class Maximumdifferenceijkl {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=in.nextInt();
        System.out.println(maximumDiff(ar));
    }

    static int maximumDiff(int[] ar) {
        int[] table1 = new int[ar.length];
        int[] table2 = new int[ar.length-1];
        int[] table3 = new int[ar.length-2];
        int[] table4 = new int[ar.length-3];
        Arrays.fill(table1,Integer.MIN_VALUE);
        Arrays.fill(table2,Integer.MIN_VALUE);
        Arrays.fill(table3,Integer.MIN_VALUE);
        Arrays.fill(table4,Integer.MIN_VALUE);

        table1[ar.length-1]=ar[ar.length-1];
        for(int i=ar.length-2;i>=0;i--)
            table1[i]=Math.max(table1[i+1], ar[i]);
        table2[table2.length-1] = table1[table1.length-1]-ar[table2.length-1];
        for(int i =table2.length-2;i>=0;i--)
            table2[i]=Math.max(table2[i+1], table1[i+1]-ar[i]);
        table3[table3.length-1]=table2[table2.length-1]+ar[table3.length-1];
        for(int i=table3.length-2;i>=0;i--)
            table3[i] = Math.max(table3[i+1],table2[i+1]+ar[i]);
        table4[table4.length-1]=table3[table3.length-1]-ar[table4.length-1];
        for(int i=table4.length-2;i>=0;i--)
            table4[i]=Math.max(table4[i+1], table3[i+1]-ar[i]);
        return table4[0];
    }
}