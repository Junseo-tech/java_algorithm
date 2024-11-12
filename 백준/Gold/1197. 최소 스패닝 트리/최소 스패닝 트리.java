import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int a, b, weight;
        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static void makeSet() {
        for(int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    static int find(int v) {
        if(parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        if(rootA < rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
        return true;
    }

    private static int V,E;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V];

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(start, end, weight));
        }

        makeSet();

        int cost = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(union(e.a, e.b)) {
                cost += e.weight;
                if(++count==V-1) break;
            }
        }

        System.out.println(cost);
    }
}