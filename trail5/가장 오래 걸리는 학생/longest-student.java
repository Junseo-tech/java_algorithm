import java.util.*;
import java.io.*;


class Node implements Comparable<Node>{
    int idx;
    int weight;

    public Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }

    public int compareTo(Node n) {
        return this.weight - n.weight;
    }

}

// 학교에서 다른 장소들까지 가는 거리를 구하면 된다. 다익스트라.
public class Main {
    static List<List<Node>> graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 장소의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        dist = new int[n];

        graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(n-1);

        int answer = 1;
        for(int num : dist) {
            answer = Math.max(answer, num);
        }

        System.out.print(answer);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            for(Node next : graph.get(temp.idx)) {
                if(dist[temp.idx] + next.weight < dist[next.idx]) {
                    dist[next.idx] = dist[temp.idx] + next.weight;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
}