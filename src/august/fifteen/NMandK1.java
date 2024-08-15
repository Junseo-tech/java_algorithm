package august.fifteen;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NMandK1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M,K;
    private static int[][] area;
    private static int max = Integer.MIN_VALUE;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException  {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                visited[i][j] = true;
                int[] chosen = new int[K];
                chosen[0] = area[i][j];
                back_tracking(1,i,j, chosen);
            }
        }
        System.out.println(max);
    }

    static void back_tracking(int depth, int start, int end, int[] chosen){
        if(depth == K){
            int sum = 0;
            for(int i = 0; i < K; i++){
                sum += chosen[i];
            }
            if(sum > max){
                max = sum;
            }
            return;
        } else {
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!visited[i][j] && isValid(i, j)){
                        visited[i][j] = true;
                        chosen[depth] = area[i][j];
                        //System.out.println("i :  "+ i + " " + "j : " + j + " visited : " + Arrays.deepToString(visited));
                        back_tracking(depth+1,i,j,chosen);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    static boolean isValid(int target_x, int target_y){
        for(int i = 0; i < 4; i++){
            int nx = target_x + dx[i];
            int ny = target_y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }
}
