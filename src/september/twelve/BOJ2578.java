import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2578 {
    private static int[][] bingo = new int[5][5];
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[][] visited = new boolean[5][5];
    private static int[] numbers = new int[25];
    private static int[] dx = {-1,1,0,0,1,1,-1,-1};
    private static int[] dy = {0,0,-1,1,1,-1,1,-1};
    private static int bingoCount = 0;
    private static int answer;
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                numbers[i * 5 + j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k = 0; k < 25; k++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(bingo[i][j] == numbers[k]) {
                        visited[i][j] = true;
                        int count = isBingo();
                        if(count >= 3) {
                            answer = k + 1;
                            System.out.println(answer);
                            return;
                        }
                    }
                }
            }
        }


    }

    private static int isBingo() {
        int count = 0;

        //행 확인
        for (int i = 0; i < 5; i++) {
            boolean row = true;
            for (int j = 0; j < 5; j++) {
                if(!visited[i][j]) row = false;
            }
            if(row) count++;
        }



        for (int i = 0; i < 5; i++) {
            boolean col = true;
            for (int j = 0; j < 5; j++) {
                if(!visited[j][i]) col = false;
            }
            if(col) count++;
        }

        // 대각선 확인
        boolean first = true;
        boolean second = true;

        for(int i = 0; i < 5; i++) {
            if(!visited[i][i]) first = false;
            if(!visited[i][4-i]) second = false;
        }
        if(first) count++;
        if(second) count++;

        return count;
    }
}

