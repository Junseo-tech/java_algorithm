import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int v, weight;
        Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    private static int V,E,K;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Node>[] nodes;
    private static int[] dist;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine()) - 1;

        nodes = new List[V];
        dist = new int[V];

        for(int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < V; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            nodes[u].add(new Node(v, w));
        }

        dijkstra();
        for(int i = 0; i < V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));
        dist[K] = 0;
        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            for(Node node : nodes[temp.v]) {
                if(dist[node.v] > temp.weight + node.weight) {
                    dist[node.v] = temp.weight + node.weight;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }
    }
}