import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static ArrayList<Integer>[] graph; // int[] 가 정수를 담은 배열인 것 처럼 리스트를 담은 배열임
    private static boolean[] visited;
    private static int[] map;
    private static int MAX_NUM;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N <= 10,000
        M = Integer.parseInt(st.nextToken()); // M <= 100,000

        graph = new ArrayList[N + 1];
        map = new int[N + 1];
        visited = new boolean[N + 1];

        MAX_NUM = Integer.MIN_VALUE;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(graph[b] == null) {
                graph[b] = new ArrayList<>();
            }
            graph[b].add(a);
        }

        for(int i = 1; i <= N; i++) { // O (N * (N + M)) => O(N^2) 10,000 ^ 2 + 10,000 * 100,000
            // 10,000 * 10,000 + 십억 => 시초
            int result = dfs(i);
            map[i] = result;
            Arrays.fill(visited, false); // 매번 boolean 배열 초기화 하면 10,000번의 객체 생성과 가비지 컬렉션이 누적되기 때문에 이렇게
            MAX_NUM = Math.max(result , MAX_NUM);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(map[i] == MAX_NUM) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static int dfs(int start) { // O(V + E) O(N + M)
        visited[start] = true;
        int hacked = 1;

        ArrayList<Integer> currentList = graph[start];
        if(currentList == null) return 1;

        for(int i=0; i < currentList.size(); i++) {
            int temp = currentList.get(i);
            if(!visited[temp]) {
                hacked += dfs(temp); // dfs 횟수를 누적한다.
            }
        }
        return hacked;
    }
}
