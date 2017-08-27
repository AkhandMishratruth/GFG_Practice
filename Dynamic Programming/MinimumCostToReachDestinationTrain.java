import java.util.*;
import java.io.*;

public class MinimumCostToReachDestinationTrain {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int[][] graph = {{0,15,80,90},
                {Integer.MAX_VALUE, 0, 40, 50},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 70},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}};
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        for(int i=0;i<graph.length;i++){
            for(int j =i+1;j<graph[0].length;j++){
                dist[j]=Math.min(dist[j], dist[i]+graph[i][j]);
            }
        }
        System.out.println(dist[graph.length-1]);
    }
}