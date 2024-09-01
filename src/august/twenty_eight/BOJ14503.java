import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {

    private static int N, M;
    private static int[][] graph;
    private static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    private static int[] dy = {0, 1, 0, -1}; // 북 동 남 서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            graph[r][c] = 2; // 현재 위치를 청소

            if (isExist(r, c)) { // 주변에 청소되지 않은 칸이 있는지 확인
                while (true) {
                    d = (d + 3) % 4; // 왼쪽으로 회전
                    int nx = r + dx[d];
                    int ny = c + dy[d];

                    if (graph[nx][ny] == 0) { // 청소되지 않은 칸이 있으면 이동
                        r = nx;
                        c = ny;
                        break;
                    }
                }
            } else { // 주변에 청소되지 않은 칸이 없으면
                int backX = r - dx[d];
                int backY = c - dy[d];

                if (graph[backX][backY] == 1) { // 뒤가 벽이면 종료
                    break;
                } else { // 벽이 아니면 후진
                    r = backX;
                    c = backY;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 2) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static boolean isExist(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 0) {
                return true;
            }
        }
        return false;
    }
}
