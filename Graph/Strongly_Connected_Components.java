import java.util.*;
import java.io.*;

public class Strongly_Connected_Components {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt(), e = in.nextInt();
        Graph Thegra = new Graph(v);
        while (e-- > 0)
            Thegra.setEdge(in.nextInt(), in.nextInt());
        Thegra.ForwardDFS();
        Thegra.ReverseDFS();
    }
}
class Graph {
    int vertex;
    HashMap<Integer, LinkedList<Integer>> Gra;
    HashMap<Integer, LinkedList<Integer>> RevGra;
    Stack<Integer> st = new Stack<Integer>();

    Graph(int v) {
        vertex = v;
        Gra = new HashMap<Integer, LinkedList<Integer>>();
        RevGra = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 1; i <= vertex; i++) {
            Gra.put(i, new LinkedList<Integer>());
            RevGra.put(i, new LinkedList<Integer>());
        }
    }

    void setEdge(int s, int d) {
        Gra.get(s).add(d);
        RevGra.get(d).add(s);
    }

    void ForwardDFS() {
        boolean visited[] = new boolean[vertex + 1];
        int[] group = new int[vertex + 1];
        Arrays.fill(group, -1);
        for (int i = 1; i <= vertex; i++) {
            if(!visited[i]){
                visited[i]=true;
                DFS(i, visited, group, false);
            }
        }
        for(int i:group)
            System.out.print(i+" ");
        System.out.println();
    }

    void DFS(int i, boolean[] vis, int[] grp, boolean rev) {
        vis[i] = true;
        int temp;
        HashMap<Integer, LinkedList<Integer>> gra;
        if (rev)
            gra = RevGra;
        else
            gra = Gra;
        Iterator it = gra.get(i).iterator();
        while (it.hasNext()) {
            temp = (int) it.next();
            if(!vis[temp]) {
                grp[temp] = i;
                DFS(temp, vis, grp, rev);
            }
        }
        st.push(i);
    }

    void ReverseDFS() {
        boolean visited[] = new boolean[vertex + 1];
        int[] group = new int[vertex + 1];
        Arrays.fill(group, -1);
        while (!st.isEmpty()) {
            int te = st.pop();
            if(!visited[te])
                DFS(te, visited, group, true);
        }
        for (int i : group)
            System.out.print(i + " ");
    }
}