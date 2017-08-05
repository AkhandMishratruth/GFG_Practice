import java.util.*;
import java.io.*;

public class bfs {
    public static void main(String args[]) throws Exception {
        PrintWriter p = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        int v = in.nextInt(), e = in.nextInt();
        Graph theGra = new Graph(v);
        while(e-->0)
            theGra.setEdge(in.nextInt(),in.nextInt());
        theGra.bfs(1);
    }
}
class Graph{
    HashMap<Integer, List<Integer>> Gra;
    int vertex;
    Graph(int v){
        Gra = new HashMap<Integer, List<Integer>>();
        vertex = v;
        for(int i =1;i<=vertex;i++)
            Gra.put(i,new LinkedList<Integer>());
    }
    void setEdge(int s, int d){
        Gra.get(s).add(d);
        Gra.get(d).add(s);
    }
    void bfs(int s){
        boolean[] visited = new boolean[vertex+1];
        int[] dist = new int[vertex+1];
        dist[s]=0;
        visited[s]=true;
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(s);
        int tem1, tem2;
        while(!q.isEmpty()){
            tem1 = q.poll();
            Iterator it = Gra.get(tem1).iterator();
            while(it.hasNext()){
                tem2 = (int)it.next();
                if(!visited[tem2]) {
                    visited[tem2] = true;
                    q.add(tem2);
                    dist[tem2] = dist[tem1] + 1;
                }
            }
        }
        for(int i:dist)
            System.out.print(i+" ");
    }
}