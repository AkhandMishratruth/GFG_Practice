import java.util.*;
import java.io.*;

public class Detect_Cycle_in_an_Undirected {
    static int[] root;
    public static void main(String args[]) throws Exception {
        PrintWriter p = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        int V=in.nextInt(), E = in.nextInt();
        root = new int[V+1];
        Edge[] edge_lis = new Edge[E];
        Arrays.fill(root,-1);
        for(int i = 0;i<E;i++)
            edge_lis[i]=new Edge(in.nextInt(),in.nextInt());
        for(int i=0;i<edge_lis.length;i++){
            if(parent(edge_lis[i].fir)==parent(edge_lis[i].se) && parent(edge_lis[i].se)!=-1){
                System.out.println("true");
                break;
            }
            else if(i==E-1)
                System.out.println("false");
            else {
                union(edge_lis[i].fir,edge_lis[i].se);
            }
        }
    }
    static void union(int a, int b){
        int f = parent(a);
        int g = parent(b);
        root[f]=g;
    }
    static int parent(int a){
        if(root[a]==-1)
            return a;
        return parent(root[a]);
    }
}
class Edge{
    int fir, se;
    Edge(int a, int b){
        fir=a;
        se=b;
    }
}