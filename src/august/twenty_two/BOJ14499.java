package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {

    private static int N, M, x, y, K;
    private static int[][] maps;
    private static int[] orders;
    private static int[] dice = new int[6]; // 주사위 초기화: [왼, 바닥, 오, 위, 아래, 뚜껑]

    // 동, 서, 북, 남
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        maps = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        orders = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        int currentX = x, currentY = y;

        for (int order : orders) {
            boolean flag = move(order, currentX, currentY);
            if (flag) {
                System.out.println(dice[5]); // 주사위 윗 면 출력
                currentX = x;
                currentY = y;
            }
        }
    }

    private static boolean move(int num, int currentX, int currentY) {
        int nx = currentX + dx[num - 1];
        int ny = currentY + dy[num - 1];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
            return false; // 지도 바깥으로 이동하면 false
        }

        x = nx;
        y = ny;

        if (num == 1) { // 동쪽
            int temp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[5];
            dice[5] = temp;
        } else if (num == 2) { // 서쪽
            int temp = dice[5];
            dice[5] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[0];
            dice[0] = temp;
        } else if (num == 3) { // 북쪽
            int temp = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[4];
            dice[4] = dice[1];
            dice[1] = temp;
        } else if (num == 4) { // 남쪽
            int temp = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[3];
            dice[3] = temp;
        }

        if (maps[x][y] == 0) {
            maps[x][y] = dice[1];
        } else {
            dice[1] = maps[x][y];
            maps[x][y] = 0;
        }

        return true;
    }
}
