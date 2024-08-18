package august.eighteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
    static class Node {
        int v;
        int cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int V,E,K;
    private static ArrayList<Node>[] graph;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }

    }

    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        q.add(new Node(start,0));
        dist[start] = 0;
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(!visited[temp.v]){
                visited[temp.v] = true;
            }
            for(Node next : graph[temp.v]){
                if(!visited[next.v] && next.cost + temp.cost < dist[next.v]){
                    dist[next.v] = temp.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
