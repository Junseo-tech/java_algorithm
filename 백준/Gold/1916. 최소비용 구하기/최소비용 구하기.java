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
    private static int N,M;
    private static List<Node>[] graph;
    private static int[] dist;
    private static int goalStart, goalEnd;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new List[N];
        dist = new int[N];

        for(int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        goalStart = Integer.parseInt(st.nextToken()) - 1;
        goalEnd = Integer.parseInt(st.nextToken()) - 1;

        dijkstra();

        System.out.println(dist[goalEnd]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(goalStart, 0));
        dist[goalStart] = 0;
        while(!pq.isEmpty()) {
            Node temp = pq.poll();

            if(dist[temp.v] < temp.weight) continue;
            
            for(Node node : graph[temp.v]) {
                if(dist[node.v] > node.weight + temp.weight){
                    dist[node.v] = node.weight + temp.weight;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }
    }
}