package september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mst_kruskal {
    private static int V,E;
    private static int[] parents;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class Edge implements Comparable<Edge> {
        int prev, next, weight;

        public Edge(int prev, int next, int weight) {
            this.prev = prev;
            this.next = next;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static void makeSet(){
        parents = new int[V + 1];
        Arrays.fill(parents, -1);
    }

    static int findSet(int a){
        if(parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b){
        int rootA = findSet(a);
        int rootB = findSet(b);
        if(rootA == rootB) return false;
        if(rootA < rootB){
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            Edge[] edges = new Edge[E];
            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                Edge edge = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                edges[i] = edge;
            }

            makeSet();
            Arrays.sort(edges);

            int cnt = 0;
            long cost = 0;
            for(Edge edge : edges){
                if(union(edge.prev, edge.next)){
                    cost += edge.weight;
                    if(++cnt == V-1) break;
                }
            }
            sb.append("#").append(tc).append(" ").append(cost).append("\n");
        }
        System.out.println(sb);
    }
}
