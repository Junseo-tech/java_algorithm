import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class flower_road {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int answer = Integer.MAX_VALUE;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // 배열 생성
        int[][] flowers = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                flowers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];

        // 개화 가능한 꽃 위치 선별 하기 -> 중앙 씨앗 : 굳이 리스트로 만들 필요 없음
        // visited[][] 활용해서 씨앗 놓은거 체크 해주기

        backTracking(N, 0, flowers, 0);
        System.out.println(answer);
    }

    private static void backTracking(int N, int depth, int[][] flowers, int sum){
        if(depth == 3){
            answer = Math.min(sum, answer);
            return;
        }
        for (int x = 1; x < N-1; x++) {
            for (int y = 1; y < N-1; y++) {
                if (!visited[x][y] && isPossible(x,y,N)) {
                    applyFlowers(x,y);
                    int cost = doCalculate(x, y, flowers);
                    backTracking(N, depth + 1, flowers, sum + cost);
                    removeFlower(x, y);
                }
            }
        }

    }


    // 개화할 수 있는 것인지 판별
    private static boolean isPossible (int x, int y, int N) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    private static void applyFlowers(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < visited.length && ny < visited.length) {
                visited[nx][ny] = true;
            }
        }
    }
    // 백 트래킹
    private static void removeFlower(int x, int y) {
        visited[x][y] = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < visited.length && ny < visited.length) {
                visited[nx][ny] = false;
            }
        }

    }

    private static int doCalculate(int x, int y, int[][] flowers){
        int sum = flowers[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            sum += flowers[nx][ny];
        }
        return sum;
    }

}
