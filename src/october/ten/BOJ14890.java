package october.ten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890 {
    private static int N,X;
    private static int[][] area;
    private static int result = 0;
    private static int[][] rotate;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        area = new int[N][N];
        rotate = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeSlope();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotate[i][j] = area[j][i];
            }
        }
        area = rotate;
        makeSlope();

        System.out.println(result);
    }

    private static void makeSlope() {
        for (int i = 0; i < N; i++) {
            int firstNum = area[i][0];
            int count = 0; // 같은 높이의 경사로의 숫자
            for (int j = 0; j < N; j++) {
                if(firstNum == area[i][j]) {
                    count += 1;
                } else if(firstNum - area[i][j] == 1 && count >= 0) { // 1만큼 작아진 경우
                    count = -X + 1; //앞으로 X칸
                    firstNum = area[i][j];
                } else if(firstNum - area[i][j] == -1 && count >= X) { // 1만큼 커진 경우
                    count = 1;
                    firstNum = area[i][j];
                } else {
                    count = -1;
                    break;
                }
            }
            if(count >= 0) {
                result += 1;
            }
        }

    }
}
