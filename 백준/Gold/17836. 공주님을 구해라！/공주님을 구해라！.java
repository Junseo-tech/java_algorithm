import java.util.*;
import java.io.*;

public class Main {
    private static int N,M,T;
    private static int[][] castle;
    private static int[] dx = new int[] {-1,1,0,0};
    private static int[] dy = new int[] {0,0,-1,1};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        castle = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(0,0);
        if(result == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        visited[i][j][0] = true;
        int count = 0;
        int sword = 0;
        queue.add(new int[]{i, j, count, sword});
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            int tempC = temp[2];
            int tempS = temp[3];

            if(castle[tempX][tempY] == 2) tempS = 1;
            if(tempC > T) return -1;
            if(tempX == N - 1 && tempY == M - 1) {
                return tempC;
            }
            for(int d = 0; d < 4; d++) {
                int nx = tempX + dx[d];
                int ny = tempY + dy[d];
                if(tempS == 0 &&nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny][tempS] && castle[nx][ny] != 1) {
                    visited[nx][ny][tempS] = true;
                    queue.add(new int[]{nx, ny, tempC + 1, tempS});
                }
                if(tempS == 1 &&nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny][tempS]) {
                    visited[nx][ny][tempS] = true;
                    queue.add(new int[]{nx, ny, tempC + 1, tempS});
                }
            }
        }

        return -1;
    }
}
