import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[][] map;
    private static int answer;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        visited[0] = true;
        backtracking(1, 0, visited , 0);

        System.out.println(answer);
    }

    // 0 1 2 3 4 0
    // 1 2 3 4 0 1
    // 4 3 2 0 1 4

    private static void backtracking(int depth, int start, boolean[] visited, int weight) {
        if(weight >= answer) return;
        
        if(depth == N) {
            if(map[start][0] != 0) {
                answer = Math.min(answer, weight + map[start][0]);
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(map[start][i] != 0 && !visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i, visited, weight + map[start][i]);
                visited[i] = false;
            }
        }
    }
}
