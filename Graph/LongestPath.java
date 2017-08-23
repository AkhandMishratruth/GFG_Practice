import java.util.*;
import java.io.*;

public class LongestPath {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Graph TheGra = new Graph(n);
        while(m-->0){
            TheGra.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
        }
        TheGra.longestDist(2);
    }
}
class Graph{
    int vertex;
    HashMap<Integer, LinkedList<pair>> gra = new HashMap<Integer, LinkedList<pair>>();
    Graph(int n){
        vertex = n;
        for(int i =1;i<=vertex;i++)
            gra.put(i, new LinkedList<pair>());
    }
    void addEdge(int s, int d, int wt){
        gra.get(s).add(new pair(d,wt));
    }
    void topological(int i, boolean[] visit, Stack<Integer> st){
        visit[i]=true;
        pair temp;
        Iterator it = gra.get(i).iterator();
        while (it.hasNext()) {
            temp = (pair) it.next();
            if (!visit[temp.val])
                topological(temp.val, visit, st);
        }
        st.add(i);
    }
    void longestDist(int s){
        int[] dist = new int[vertex+1];
        Arrays.fill(dist, Integer.MIN_VALUE);
        Stack<Integer> st = new Stack<Integer>();
        boolean[] visited = new boolean[vertex+1];
        for(int i =1;i<=vertex;i++)
            if(!visited[i])
                topological(i,visited, st);
        dist[s]=0;
        pair temp;
        while (!st.isEmpty()){
            int u = st.pop();
            Iterator it = gra.get(u).iterator();
            while(it.hasNext()){
                temp = (pair) it.next();
                dist[temp.val]= Math.max(dist[temp.val], dist[u] + temp.wt);
            }
        }
        for(int i =1;i<=vertex;i++)
            System.out.print(dist[i]+" ");
    }
}
class pair{
    int val;
    int wt;
    pair(int v, int w){
        val=v;
        wt=w;
    }
}