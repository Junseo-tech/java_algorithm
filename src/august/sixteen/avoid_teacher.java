package august.sixteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class avoid_teacher {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static char[][] classroom;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static List<int[]> teachers = new ArrayList<>();
    private static boolean flag;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        classroom = new char[N][N];
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                classroom[i][j] = st.nextToken().charAt(0);
                if(classroom[i][j] == 'T') {
                    teachers.add(new int[] {i, j});
                }
            }
        }
        flag = false;
        makeObstacle(0);

        if(flag){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean bfs(){
        for(int[] t : teachers){
            int temp_x = t[0];
            int temp_y = t[1];
            for(int i = 0; i < 4; i++){
                int nx = temp_x+ dx[i];
                int ny = temp_y+ dy[i];
                while(0 <= nx && nx < N && 0 <= ny && ny < N){
                    if(classroom[nx][ny] == 'O'){
                        break;
                    }
                    if(classroom[nx][ny] == 'S'){
                        return false;
                    }
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        return true;
    }

    private static void makeObstacle(int count){
        if(flag) return;
        if(count == 3) {
            if (bfs()) {
                flag = true;
            }
            return;
        } else {
        for(int i = 0 ; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                if (classroom[i][j] == 'X') {
                    classroom[i][j] = 'O';
                    makeObstacle(count + 1);
                    classroom[i][j] = 'X';
                }

            }
        }
        }
    }

}
