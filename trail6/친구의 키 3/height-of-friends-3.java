import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] edges;
    static int[] indegree;
    static PriorityQueue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        indegree = new int[n];
        queue = new PriorityQueue<>();
        edges = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a-1].add(b-1);
            indegree[b-1]++;
        }

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int x = queue.poll();

            sb.append(x + 1).append(" ");
            count++;

            for(int i = 0; i < edges[x].size(); i++) {
                
                int y = edges[x].get(i);
                indegree[y]--;

                if(indegree[y] == 0) {
                    queue.add(y);
                }
            }
        }

        if(count == n) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}