package august.twenty_four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M,R;
    private static int[][] map;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            rotate();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void rotate() {
        int x = 0;
        int y = 0;
        int start_x = 0;
        int start_y = 0;
        int dir = 0;
        int nx = 0;
        int ny = 0;
        int temp = map[start_x][start_y];
        int next = 0;
        visited = new boolean[N][M];

        while(true){
            x = nx;
            y = ny;

            nx = x + dx[dir];
            ny = y + dy[dir];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]){
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];

            }

            if(nx == start_x && ny == start_y){
                map[nx][ny] = temp;
                nx += 1;
                ny += 1;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]){
                    break;
                } else {
                    start_x = nx;
                    start_y = ny;
                    dir = 0;
                    temp = map[start_x][start_y];
                    continue;
                }
            }

            next = map[nx][ny];
            map[nx][ny] = temp;
            temp = next;
            visited[nx][ny] = true;
        }
    }
}
