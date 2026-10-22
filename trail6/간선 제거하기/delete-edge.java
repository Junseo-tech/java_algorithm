import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int start;
    int end;
    int weight;

    public Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Node n) {
        return this.weight - n.weight;
    }

}

public class Main {
    static int[] parents;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();

        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int totalWeight = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            totalWeight += w;

            pq.add(new Node(u, v, w));
        }

        int tempWeight = 0;
        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            if(find(temp.start) != find(temp.end)) {
                union(temp.start, temp.end);
                tempWeight += temp.weight;
            }
        }

        System.out.println(totalWeight - tempWeight);
    }

    private static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX < rootY) {
            parents[rootY] = rootX;
        } else {
            parents[rootX] = rootY;
        }
    }
}