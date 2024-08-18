package august.eighteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1913 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int findNum;
    private static int[] dx= {1, 0, -1, 0};
    private static int[] dy= {0, 1, 0, -1};
    private static int[][] snails;
    private static int answer_x;
    private static int answer_y;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        findNum = Integer.parseInt(br.readLine());
        snails = new int[N][N];
        visited = new boolean[N][N];

        int startNum = N * N;
        makeSnails(startNum, 0,0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(snails[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(answer_x + 1).append(" ").append(answer_y + 1);
        System.out.println(sb);
    }

    private static void makeSnails(int startNum, int x, int y) {
        int dir = 0;
        for (int i = 0; i < N * N; i++){
            visited[x][y] = true;
            if(startNum == findNum){
                answer_x = x;
                answer_y = y;
            }
            snails[x][y] = startNum--;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]){
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;

        }
    }
}
