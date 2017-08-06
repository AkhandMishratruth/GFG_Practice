import java.util.*;
import java.io.*;

public class Weighted_Job_Scheduling {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Job[] job = new Job[n];
        for(int i = 0;i<n;i++)
            job[i] = new Job(in.nextInt(),in.nextInt(),in.nextInt());
        Arrays.sort(job, Job.com);
        int[] table = new int[n];
        table[0] = job[0].profit;
        int l,ans=Integer.MIN_VALUE;
        for(int i =1;i<table.length;i++){
            l = lastNearest(job, i);
            if(l!=-1)
                ans = Math.max(table[l]+job[i].profit, table[i-1]);
            else
                ans = Math.max(job[i].profit,table[i-1]);
        }
        System.out.println(ans);
    }
    static int lastNearest(Job[] ar, int i){
        for(int j=i-1;j>=0;j--){
            if(ar[j].finish<=ar[i].start)
                return j;
        }
        return -1;
    }
}

class Job{
    int start, finish, profit;
    Job(int a, int b, int c){
        start = a;
        finish = b;
        profit = c;
    }

    static Comparator<Job> com = new Comparator<Job>() {
        @Override
        public int compare(Job o1, Job o2) {
            return Integer.compare(o1.finish,o2.finish);
        }
    };
}