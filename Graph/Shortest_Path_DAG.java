import java.util.*;
import java.io.*;

public class Shortest_Path_DAG {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt(), e = in.nextInt();
        Graph Thegra = new Graph(v);
        while (e-- > 0)
            Thegra.setEdge(in.nextInt(), in.nextInt(), in.nextInt());
        Thegra.topo();
        Thegra.minDist(2);
    }
}
class Graph {
    int vertex;
    HashMap<Integer, LinkedList<Node>> Gra;
    Stack<Integer> st = new Stack<Integer>();

    Graph(int v) {
        vertex = v;
        Gra = new HashMap<Integer, LinkedList<Node>>();
        for (int i = 1; i <= vertex; i++)
            Gra.put(i, new LinkedList<Node>());
    }

    void setEdge(int s, int d, int wt) {
        Gra.get(s).add(new Node(d, wt));
    }

    void topo(){
        boolean[] visited = new boolean[vertex+1];
        for(int i=1;i<vertex+1;i++){
            if(!visited[i])
                dfs(i, visited);
        }
    }
    void dfs(int i, boolean[] vis){
        vis[i]=true;
        Node n;
        Iterator it = Gra.get(i).iterator();
        while(it.hasNext()){
            n= (Node) it.next();
            if(!vis[n.d])
                dfs(n.d,vis);
        }
        st.push(i);
    }
    void minDist(int i){
        int[] dist = new int[vertex+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[i]=0;
        int temp;
        Node te;
        while (!st.isEmpty()){
            temp = st.pop();
            Iterator it = Gra.get(temp).iterator();
            while (it.hasNext() && dist[temp]!=Integer.MAX_VALUE){
                te = (Node) it.next();
                if(dist[te.d] > dist[temp] + te.wt)
                    dist[te.d] = dist[temp] + te.wt;
            }
        }
        for(int j =1;j<vertex+1;j++)
            System.out.print(dist[j]+" ");
    }
}
class Node{
    int d,wt;
    Node(int a,int b){
        d =a;
        wt=b;
    }
}