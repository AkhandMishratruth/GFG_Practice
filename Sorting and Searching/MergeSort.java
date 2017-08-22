import java.util.*;
import java.io.*;

public class MergeSort {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++)
            ar[i] = in.nextInt();
        ar = sort(ar,0 ,ar.length-1);
        for(int i:ar)
            System.out.print(i+" ");
    }

    static int[] sort(int[] ar, int l, int r) {
        if (l == r){
            int[] arr = new int[1];
            arr[0]=ar[l];
            return arr;
        }
        else {
            int mid = (l + r) / 2;
            int[] left = sort(ar, l, mid);
            int[] right = sort(ar, mid + 1, r);
            int[] toret = new int[left.length + right.length];
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    toret[k] = left[i];
                    i++;
                    k++;
                } else {
                    toret[k] = right[j];
                    j++;
                    k++;
                }
            }
            while (i < left.length) {
                toret[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                toret[k] = right[j];
                j++;
                k++;
            }
            return toret;
        }
    }
}