package august.thirteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] ladder  = new int[100][100];
    private static boolean[][] visited;
    private static int definition_x;
    private static int definition_y;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if(ladder[i][j] == 2) {
                        definition_x = i;
                        definition_y = j;
                    }
                }
            }
            visited = new boolean[100][100];
            int answer = findStart();
            sb.append("#").append(T).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }

    private static int findStart() {
        int temp_x = definition_x;
        int temp_y = definition_y;
        visited[temp_x][temp_y] = true;
        while(temp_x > 0){
            if(temp_y > 0 && ladder[temp_x][temp_y-1] == 1 && !visited[temp_x][temp_y-1]) {
                while(temp_y > 0 && ladder[temp_x][temp_y-1] == 1){
                    temp_y--;
                    visited[temp_x][temp_y] = true;
                }
            }
            else if(temp_y < 99 && ladder[temp_x][temp_y+1] == 1) {
                while (temp_y < 99 && ladder[temp_x][temp_y + 1] == 1 && !visited[temp_x][temp_y + 1]) {
                    temp_y++;
                    visited[temp_x][temp_y] = true;
                }
            }
            temp_x --;

        }
        return temp_y;
    }

}