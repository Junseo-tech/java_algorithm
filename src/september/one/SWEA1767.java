package september.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1767 {
    private static int N;
    private static int[][] maxi;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<int[]> candidates = new ArrayList<>();
    private static int maxConnected;  // 최대 연결된 코어 수
    private static int minLength;  // 최소 전선 길이
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            maxi = new int[N][N];
            candidates.clear();
            maxConnected = 0;
            minLength = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    maxi[i][j] = Integer.parseInt(st.nextToken());
                    if (maxi[i][j] == 1) {
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                            continue;  // 이미 가장자리에 있는 코어는 연결할 필요 없음
                        } else {
                            candidates.add(new int[]{i, j}); // 가장자리가 아닌 코어들만 후보에 추가
                        }
                    }
                }
            }

            dfs(0, 0, 0);
            sb.append("#").append(t).append(" ").append(minLength).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int index, int connected, int length) {
        if (index == candidates.size()) {
            if (connected > maxConnected) {
                maxConnected = connected;
                minLength = length;
            } else if (connected == maxConnected) {
                minLength = Math.min(minLength, length);
            }
            return;
        }

        int x = candidates.get(index)[0];
        int y = candidates.get(index)[1];


        for (int d = 0; d < 4; d++) {
            int lengthToAdd = checkAndPlaceWire(x, y, d);

            if (lengthToAdd != -1) {  // 연결이 가능하다면
                dfs(index + 1, connected + 1, length + lengthToAdd);
                removeWire(x, y, d, lengthToAdd);  // 연결이 끝난 후 전선 제거
            }
        }

        // 연결하지 않고 다음 코어로 넘어가는 경우
        dfs(index + 1, connected, length);
    }

    static int checkAndPlaceWire(int x, int y, int direction) {
        int nx = x;
        int ny = y;
        int length = 0;

        while (true) {
            nx += dx[direction];
            ny += dy[direction];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                // 가장자리까지 도달하면 성공
                int tempX = x, tempY = y;
                for (int i = 0; i < length; i++) {
                    tempX += dx[direction];
                    tempY += dy[direction];
                    maxi[tempX][tempY] = 2; // 전선을 설치
                }
                return length;
            }

            if (maxi[nx][ny] != 0) {
                return -1;  // 다른 코어나 전선이 있는 경우
            }

            length++;
        }
    }

    static void removeWire(int x, int y, int direction, int length) {
        int nx = x;
        int ny = y;

        for (int i = 0; i < length; i++) {
            nx += dx[direction];
            ny += dy[direction];
            maxi[nx][ny] = 0; // 전선을 제거함
        }
    }
}
