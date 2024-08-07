package august.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class make_color_paper {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] paper;
    private static int blue = 0;
    private static int white = 0;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        splitPaper(0,0,N-1,N-1);
        System.out.println(white);
        System.out.println(blue);
    }

    private static int hasDifferent(int start_x, int start_y,int end_x, int end_y){
        int firstColor = paper[start_x][start_y];
        for(int i = start_x; i <= end_x; i++){
            for(int j = start_y; j <= end_y; j++){
                if(firstColor != paper[i][j]){
                    return -1;
                }
            }
        }
        return firstColor;
    }

    private static void splitPaper(int start_x, int start_y, int end_x, int end_y){
        int color = hasDifferent(start_x, start_y, end_x, end_y);
        if(color != -1){
            if(color == 1){
                blue ++;
            } else if(color == 0){
                white ++;
            }
        } else {
            int now_x = (start_x + end_x) / 2;
            int now_y = (start_y + end_y) / 2;

            splitPaper(start_x, start_y, now_x, now_y); // 0 0 3 3
            splitPaper(start_x, now_y + 1, now_x, end_y); // 0 4 3 7
            splitPaper(now_x + 1, start_y, end_x, now_y); // 4 0 7 3
            splitPaper(now_x + 1, now_y + 1, end_x, end_y); // 4 4 7 7

        }
    }
}
