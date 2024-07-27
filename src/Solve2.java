import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Solve2 {
    static int r, c, n;
    static char[][] arr = new char[200][200];
    static int[][] time = new int[200][200]; // 시간 저장
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        Input();
        init();
        solve();
        Output();
    }

    static void Input() throws IOException {
        tokens = new StringTokenizer(input.readLine());
        r = Integer.parseInt(tokens.nextToken());
        c = Integer.parseInt(tokens.nextToken());
        n = Integer.parseInt(tokens.nextToken());
    }

    static void init() throws IOException {
        for (int i = 0; i < r; i++) {
            String str = input.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                time[i][j] = 0;
            }
        }
    }

    static void timeUpdate() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'O') {
                    time[i][j]++;
                }
            }
        }
    }

    static void boomSeed() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == '.') {
                    arr[i][j] = 'O';
                }
            }
        }
    }

    // 상하좌우 탐색
    static void boom(int x, int y) {
        time[x][y] = 0;
        arr[x][y] = '.';
        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, 1, -1 };

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                arr[nx][ny] = '.';
                time[nx][ny] = 0;
            }
        }
    }

    static void solve() {
        // timeUpdate();
        for (int t = 0; t < n; t++) {
            timeUpdate();
            boomSeed();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (time[i][j] == 3 && arr[i][j] == 'O') {
                        boom(i, j);
                    }
                }
            }
        }
    }

    static void Output() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}