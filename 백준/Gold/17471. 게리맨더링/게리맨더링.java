import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* N이 최대 10이라 부분집합 마음 놓고 돌림
* 그래프 연결성 따지는 문제에서 하나의 노드를 잡고 bfs로 돌리는 부분은 힌트를 얻어서 함. 각 그룹별 sign을 Bfs에 넣어서 확인하는 거 얻음
* 17퍼 에러 => 만약 6개 에러가 있고, 1 : 5 로 나눈 경우는 ㄱㅊ아서 이 부분을 고려 못함 : 근데 고려 방법을 모르겠는데
* */
public class Main {
    private static int N;
    private static int[] person;
    private static int[][] graph;
    private static int solution = Integer.MAX_VALUE;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        person = new int[N];
        graph = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                int a = Integer.parseInt(st.nextToken()) - 1;
                graph[i][a] = 1;
                graph[a][i] = 1;
            }
        }

        subset(0, new boolean[N]);
        System.out.println(solution == Integer.MAX_VALUE ? -1 : solution);
    }

    private static void subset(int depth, boolean[] visited) {
        if(depth == N) {
            int answer = check(visited);
            if(answer != -1) {
                solution = Math.min(solution, answer);
            }
            return;
        }
        visited[depth] = true;
        subset(depth + 1, visited);
        visited[depth] = false;
        subset(depth + 1, visited);
    }

    private static int check(boolean[] visited) {
        int startA = -1; // A의 시작점
        int startB = -1; // B의 시작점
        int preCountA = 0;
        int preCountB = 0;
        for(int i = 0; i < N; i++) { // group : true
            if(visited[i]) {
                if(startA == -1) startA = i;
                preCountA++;
            }
        }

        for(int i = 0; i < N; i++) { // group : false
            if(!visited[i]) {
                if(startB == -1) startB = i;
                preCountB++;
            }
        }

        if(startA != -1 && startB != -1) {
            boolean isValid = preCountA == 1 || bfs(startA, visited, true);
            boolean isValid2 = preCountB == 1 || bfs(startB, visited, false);

            int countA = 0;
            int countB = 0;
            if(isValid && isValid2) {
                for(int i = 0; i < N; i++) {
                    if(visited[i]) {
                        countA += person[i];
                    } else {
                        countB += person[i];
                    }
                }
                return Math.abs(countA - countB);
            }
        }
        return -1;
    }

    private static boolean bfs(int node, boolean[] connected, boolean connectSign) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.add(node);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i = 0; i < N; i++) {
                if(graph[cur][i] == 1 && !visited[i] && connected[i] == connectSign) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(connected[i] == connectSign && !visited[i]) {
                return false;
            }
        }
        return true;
    }
}