package september.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstra {

    static class Node {
        int v, weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int V,E,K;
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] dist;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[K] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, weight));
        }

        diskstra_method();

        for(int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    private static void diskstra_method(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(Node node : graph.get(cur.v)){
                if(node.weight + cur.weight < dist[node.v]){
                    dist[node.v] = node.weight + cur.weight;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }
    }
}
