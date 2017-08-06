import java.util.*;
import java.io.*;

public class Dijkstra {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt(), e = in.nextInt();
        Graph Thegra = new Graph(v);
        while (e-- > 0)
            Thegra.setedge(in.nextInt(), in.nextInt(), in.nextInt());
        PriorityQueue<Node> q = new PriorityQueue<Node>(v, Node.com);
        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(new Node(1, 0));
        dist[1] = 0;
        Node tem1, tem2;
        while (!q.isEmpty()) {
            tem1 = q.poll();
            if (visited[tem1.d])
                continue;
            else
                visited[tem1.d] = true;
            Iterator it = Thegra.Gra.get(tem1.d).iterator();
            while (it.hasNext()) {
                tem2 = (Node) it.next();
                if (dist[tem1.d] + tem2.wt < dist[tem2.d]) {
                    dist[tem2.d] = dist[tem1.d] + tem2.wt;
                    q.add(new Node(tem2.d, dist[tem2.d]));
                }
            }
        }
        for(int i = 2;i<dist.length;i++)
            System.out.print(dist[i]+" ");
    }
}

class Graph {
    int vertex;
    HashMap<Integer, List<Node>> Gra;

    Graph(int v) {
        vertex = v;
        Gra = new HashMap<Integer, List<Node>>();
        for (int i = 1; i <= vertex; i++)
            Gra.put(i, new LinkedList<Node>());
    }

    void setedge(int s, int d, int w) {
        Gra.get(s).add(new Node(d, w));
        Gra.get(d).add(new Node(s, w));
    }
}
class Node {
    int d, wt;

    Node(int a, int b) {
        d = a;
        wt = b;
    }

    static Comparator<Node> com = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.wt, o2.wt);
        }
    };
}