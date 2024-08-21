import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA6109 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] dx = {-1, 0, 1, 0}; // 북 서 남 동
    private static int[] dy = {0,-1,0,1};
    private static int[][] game;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            game = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    game[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            switch (dir){
                case "up":
                    for (int i = 0; i < N; i++) {
                        playgame(0, i, 2);
                    }
                    break;
                case "down":
                    for (int i = 0; i < N; i++) {
                        playgame(N-1,i,0);
                    }
                    break;
                case "left":
                    for (int i = 0; i < N; i++) {
                        playgame(i, 0, 3);
                    }
                    break;
                case "right":
                    for (int i = 0; i < N; i++) {
                        playgame(i, N-1, 1);
                    }
                    break;
            }
            sb.append("#").append(t).append("\n");
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(game[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void playgame(int x, int y, int dir){
        int temp_x = x;
        int temp_y = y;

        for(int k = 1; k < N; k++){
            int nx = x + dx[dir] * k;
            int ny = y + dy[dir] * k;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;

            if(game[nx][ny] == 0) {
                continue;
            }

            if(game[temp_x][temp_y] == 0){
                game[temp_x][temp_y] = game[nx][ny];
                game[nx][ny] = 0;

            } else if(game[temp_x][temp_y] == game[nx][ny]){
                game[temp_x][temp_y] *= 2;
                game[nx][ny] = 0;
                temp_x += dx[dir];
                temp_y += dy[dir];

            } else { // 기준, 검사 둘 다 0 아님. 다른 값
                temp_x += dx[dir];
                temp_y += dy[dir];

                game[temp_x][temp_y] = game[nx][ny];

                if(temp_x != nx || temp_y != ny){
                    game[nx][ny] = 0;
                }
            }
        }
    }
}