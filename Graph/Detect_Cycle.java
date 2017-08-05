import java.util.*;
import java.io.*;

public class Detect_Cycle {
    public static void main(String args[]) throws Exception {
        PrintWriter p = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        int v = in.nextInt(), e = in.nextInt();
        Graph theGra = new Graph(v);
        while(e-->0)
            theGra.setEdge(in.nextInt(),in.nextInt());
        System.out.print(theGra.cycle(1));
    }
}
class Graph{
    int vertex;
    HashMap<Integer, List<Integer>> Gra;
    Graph(int v){
        vertex =v;
        Gra = new HashMap<Integer, List<Integer>>();
        for(int i =1;i<=vertex;i++)
            Gra.put(i,new LinkedList<Integer>());
    }
    void setEdge(int s, int d){
        Gra.get(s).add(d);
    }
    boolean cycle(int s){
        boolean[] visited = new boolean[vertex+1];
        visited[s]=true;
        Stack<Integer> st = new Stack<Integer>();
        st.push(s);
        int tem1,tem2;
        while (!st.empty()){
            tem1 = st.pop();
            Iterator it = Gra.get(tem1).iterator();
            while (it.hasNext()){
                tem2 = (int) it.next();
                if(!visited[tem2]){
                    visited[tem2]=true;
                    st.push(tem2);
                }
                else
                    return true;
            }
        }
        return false;
    }
}