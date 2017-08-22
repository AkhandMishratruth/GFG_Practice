import java.util.*;
import java.io.*;

public class Insertion_sort {
    public static void main(String args[]) throws Exception {
        PrintWriter p = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar =  new int[n];
        for(int i = 0;i<n;i++)
            ar[i]=in.nextInt();
            sort(ar);
    }
    static void sort(int[] ar ){
        int j, key;
        for(int i =1;i<ar.length;i++){
            j = i-1;
            key = ar[i];
            while (j>=0){
                if(ar[j]>=key){
                    ar[j+1]= ar[j];
                    j--;
                }
                else
                    break;
            }
            ar[j+1]=key;
        }
        for(int i : ar)
            System.out.print(i+" ");
    }
}