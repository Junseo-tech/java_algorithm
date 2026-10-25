import java.util.*;
import java.io.*;


public class Main {
    static ArrayList<Integer>[] edges;
    static int[] indegree;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n];
        indegree = new int[n];
        queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x-1].add(y-1);
            indegree[y-1]++;
        }

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();

            System.out.print((x + 1) + " ");

            for(int i = 0; i < edges[x].size(); i++) {
                int y = edges[x].get(i);
                indegree[y]--;

                if(indegree[y] == 0) {
                    queue.add(y);
                }
            }
        }

    }
}