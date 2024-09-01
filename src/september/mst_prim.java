package september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class mst_prim {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int V,E;
    private static List<Edge>[] graph;
    static class Edge implements Comparable<Edge> {
        int next, weight;
        public Edge(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }


    static long prim(int start, int n){
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        long total = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int v = edge.next;
            int cost = edge.weight;

            if(visited[v]) continue;

            visited[v] = true;
            total += cost;

            for(Edge e : graph[v]){
                if(!visited[e.next]) {
                    pq.offer(e);
                }

            }
        }
        return total;
    }
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            for(int i = 0; i < graph.length; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[a].add(new Edge(b, w));
                graph[b].add(new Edge(a, w));
            }

            long total = prim(1, V);
            sb.append("#").append(tc).append(" ").append(total).append("\n");
        }
        System.out.println(sb);
    }
}
