package september.twelve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1996 {
    private static int N;
    private static char[][] mines;
    private static int[][] answers;
    private static int[] dx = {0,0,-1,1, -1, 1, -1, 1};
    private static int[] dy = {1,-1,0,0, 1, -1, -1, 1};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        mines = new char[N][N];
        answers = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                mines[i][j] = c[j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(mines[i][j] != '.'){
                    solve(i,j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(answers[i][j] < 0){
                    sb.append('*');
                } else if(answers[i][j] >= 10) {
                    sb.append('M');
                }else{
                    sb.append(answers[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < N && 0 <= ny && ny < N && answers[nx][ny] != -1){
                answers[nx][ny] += mines[x][y] - '0';
            }
        }
        answers[x][y] = -1;
    }
}
