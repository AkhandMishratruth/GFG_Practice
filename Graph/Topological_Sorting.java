import java.util.*;
import java.io.*;

public class Topological_Sorting {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt(), e = in.nextInt();
        Graph theGra = new Graph(v);
        for(int i =0;i<e;i++)
            theGra.setEdge(in.nextInt(), in.nextInt());
        theGra.topo();
        Iterator it = theGra.sta.iterator();
        while(it.hasNext())
            System.out.print((int)it.next()+" ");
    }
}
class Graph{
    int vertex;
    LinkedList<Integer> sta = new LinkedList<Integer>();
    HashMap<Integer, List<Integer>> Gra;
    Graph(int v){
        vertex = v;
        Gra = new HashMap<Integer, List<Integer>>();
        for(int i = 1;i<=vertex;i++)
            Gra.put(i,new LinkedList<Integer>());
    }
    void setEdge(int s, int d){
        Gra.get(s).add(d);
    }
    void topo(){
        boolean[] visit = new boolean[vertex+1];
        for(int i=1;i<=vertex;i++)
            dfs(i,visit);
    }
    void dfs(int i, boolean[] vis){
        if(!vis[i]){
            vis[i]=true;
            Iterator it = Gra.get(i).iterator();
            while (it.hasNext())
                dfs((int) it.next(),vis);
            sta.push(i);
        }
    }
}