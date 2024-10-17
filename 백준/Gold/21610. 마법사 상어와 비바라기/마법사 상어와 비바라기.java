import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N,M;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] area;
    private static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[][] command;
    private static Queue<int[]> queue = new LinkedList<>();
    private static int answer = 0;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        area = new int[N][N];
        command = new int[M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                command[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue.add(new int[]{N-1, 0});
        queue.add(new int[]{N-1, 1});
        queue.add(new int[]{N-2, 0});
        queue.add(new int[]{N-2, 1});

        skill();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += area[i][j];
            }
        }

        System.out.println(answer);

    }

    private static void skill() {
        for (int i = 0; i < M; i++) {
            int d = command[i][0] - 1; // 0-base 맞춰주기 , 방향
            int s = command[i][1];
            move(d, s);
            rain();
            copyWaterBugMagic();
            makeCloud();
        }
    }

    private static void move(int d, int s) {
        int size = queue.size();
        Queue<int[]> newQueue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            int[] temp = queue.poll();
            int temp_x = temp[0];
            int temp_y = temp[1];

            // s만큼 이동하고 나머지 연산으로 범위 안으로 들어오게 처리
            int nx = temp_x + dx[d] * s;
            int ny = temp_y + dy[d] * s;

            nx = (nx % N + N) % N;
            ny = (ny % N + N) % N;

            newQueue.add(new int[]{nx, ny});
        }
        queue = newQueue;
    }


    private static void rain() {
        visited = new boolean[N][N];
        Queue<int[]> newQueue = new LinkedList<>();
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int temp_x = temp[0];
            int temp_y = temp[1];

            newQueue.add(new int[]{temp_x, temp_y});
            visited[temp_x][temp_y] = true;

            area[temp_x][temp_y] = area[temp_x][temp_y] + 1;
        }
        queue = newQueue;
    }


    private static void copyWaterBugMagic() {
        Queue<int[]> newQueue = new LinkedList<>(queue);  // 현재 구름 좌표 복사
        while (!newQueue.isEmpty()) {
            int[] temp = newQueue.poll();
            int temp_x = temp[0];
            int temp_y = temp[1];

            int count = 0;
            // 대각선 방향 탐색
            for (int d = 1; d < 8; d += 2) {
                int nx = temp_x + dx[d];
                int ny = temp_y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (area[nx][ny] >= 1) {
                        count++;  // 대각선에 물이 있는 칸의 개수를 카운트
                    }
                }
            }
            area[temp_x][temp_y] += count;  // 물 복사
        }
    }


    private static void makeCloud() {
        Queue<int[]> newQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(area[i][j] >= 2 && !visited[i][j]) {
                    area[i][j] -= 2;
                    newQueue.add(new int[]{i, j});
                }
            }
        }
        queue = newQueue;

    }
}