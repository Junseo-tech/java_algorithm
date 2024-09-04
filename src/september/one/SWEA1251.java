package september.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1251 {
    private static int N;
    private static int[] X;
    private static int[] Y;
    private static double E;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            X = new int[N];
            Y = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                Y[i] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());

            long total = prim(0, N);

            sb.append("#").append(t).append(" ").append(Math.round(total * E)).append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int next;
        long cost;
        public Node(int next, long cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static long prim(int start, int n){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n];

        queue.offer(new Node(start, 0));
        long total = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int v = node.next;

            if(visited[v]) continue;

            visited[v] = true;
            total += node.cost;

            for(int i = 0; i < N; i++) {
                if(!visited[i]) {
                    long nextCost = calculate(v, i);
                    queue.offer(new Node(i, nextCost));
                }
            }
        }
        return total;
    }

    static long calculate(int i, int next){
        long distance = (long) (X[i] - X[next]) * (X[i] - X[next]) + (long) (Y[i] - Y[next]) * (Y[i] - Y[next]);
        return distance;
    }
}
