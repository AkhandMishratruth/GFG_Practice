import java.util.*;
import java.io.*;

public class Kruskal_MST {
    static int[] parent;
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt(), e = in.nextInt();
        parent = new int[v];
        Arrays.fill(parent,-1);
        Edge[] ed = new Edge[e];
        int sum=0;
        for(int i =0;i<e;i++)
            ed[i] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
        Arrays.sort(ed, Edge.com);
        for(int i=0;i<ed.length;i++){
            if(find(ed[i].s)!=find(ed[i].d)){
                union(ed[i].s, ed[i].d);
                System.out.println(ed[i].s+" "+ed[i].d);
                sum+=ed[i].wt;
            }
        }
        System.out.println(sum);
    }
    static int find(int a){
        if(parent[a-1]==-1)
            return a;
        return find(parent[a-1]);
    }
    static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        parent[x-1]=y;
    }
}

class Edge{
    int s, d, wt;
    Edge(int a, int b, int w){
        s=a;d=b;wt=w;
    }
    static Comparator<Edge> com = new Comparator<Edge>() {
        @Override
        public int compare(Edge o1, Edge o2) {
            return Integer.compare(o1.wt,o2.wt);
        }
    };
}