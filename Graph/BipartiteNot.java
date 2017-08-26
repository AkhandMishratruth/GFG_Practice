import java.util.*;
import java.io.*;

public class BipartiteNot {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int[][] adjMat = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}};
        int[] color = new int[adjMat.length];
        Arrays.fill(color, -1);
        System.out.println(bipartiteMain(adjMat, color));
    }
    static boolean bipartiteMain(int[][] graph, int[] col){
    	for(int i =0;i<graph.length;i++){
    		if(col[i]==-1 && !bipartite(graph, i, col)){
    			return false;
    		}
    	}
    	return true;
    }
    static boolean bipartite(int[][] graph, int source, int[] color){
    	color[source] = 1;
    	if(graph[source][source]==1)
    		return false;
    	LinkedList<Integer> q = new LinkedList<Integer>();
    	q.add(source);
    	int start;
    	while(!q.isEmpty()){
    		start = q.pop();
    		if(graph[start][start]==1)
    		    return false;
    		for(int dest = 0;dest<graph.length;dest++){
    			if(graph[start][dest]==1 && color[dest]==-1){
    				color[dest]=1-color[start];
    				q.add(dest);
    			}
    			else if(graph[start][dest]==1 && color[dest]==color[start])
    				return false;
    		}
    	}
    	return true;
    }
}

