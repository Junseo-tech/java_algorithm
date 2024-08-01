package july.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_sequence_rotate {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++){
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] arr90 = rotate(arr);
            int[][] arr180 = rotate(arr90);
            int[][] arr270 = rotate(arr180);

            sb.append("#").append(t).append("\n");
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(arr90[i][j]);
                }
                sb.append(" ");

                for(int j = 0; j < N; j++) {
                    sb.append(arr180[i][j]);
                }
                sb.append(" ");

                for(int j = 0; j < N; j++) {
                    sb.append(arr270[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }

    private static int[][] rotate(int[][] rotationArray){
        int[][] resultArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                resultArr[i][j] = rotationArray[N-1-j][i];
            }
        }
        return resultArr;
    }
}
