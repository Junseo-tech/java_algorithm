import java.util.*;
import java.io.*;

// 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우, 대각선은 아님
// 출력 => 전체 단지 수, 각 단지에 속한 집 수
public class Main {
    private static int N; // 5<=N<=25
    private static int[][] map;
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,1,-1};
    private static int total;
    private static boolean[][] visited;
    private static List<Integer> house;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        house = new ArrayList<>();
        total = 0;

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0'; // 놓친 부분
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    int size = bfs(i,j);
                    house.add(size);
                }
            }
        }

        Collections.sort(house);
        StringBuilder sb = new StringBuilder();
        sb.append(total).append("\n");

        for(int t : house) {
            sb.append(t).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, });
        visited[x][y] = true;
        total++;
        int size = 1;
        map[x][y] = total;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            for(int d = 0; d < 4; d++) {
                int nx = tempX + dx[d];
                int ny = tempY + dy[d];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    map[nx][ny] = total;
                    size++; // 결국 총 size를 묻는거니까 큐에 넣을 때 마다 추가해준다.
                }
            }
        }
        return size;
    }
}
