package august.twenty_four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926_another {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M,R;
    private static int[][] map;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
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
            rotatate();
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

    private static void rotatate() {
        int layers = Math.min(N,M) / 2;
        for(int layer = 0; layer < layers; layer++) {
            int x = layer;
            int y = layer;
            int start_x = layer;
            int start_y = layer;
            int temp = map[start_x][start_y];
            int dir = 0;
            while(true){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < layer || ny < layer || nx >= N - layer|| ny >= M - layer){
                    dir = (dir + 1) % 4;
                    continue;
                }

                int next = map[nx][ny];
                map[nx][ny] = temp;
                temp = next;

                x = nx;
                y = ny;

                if(x == start_x && y == start_y) break;

            }
        }
    }

}
