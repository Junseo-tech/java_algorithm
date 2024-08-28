package august.twenty_eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 @author 박준서
 @since
 @link https://www.acmicpc.net/problem/15683
 @timecomplex
 @performance
 @category
 @note CCTV 방향 적절히 정해서 사각 지대의 최소 크기 구하기
 */

public class BOJ15683 {

    class CCTV{
        int x;
        int y;
        int num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

    }

    private static int N,M;
    private static int[][] office;
    private static List<CCTV> cctvList;
    private static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}}; // 상하좌우
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    private static int answer = Integer.MAX_VALUE;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        cctvList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j , office[i][j]));
                }
            }
        }
        back_tracking(0);
        System.out.println(answer);
    }

    private static void back_tracking(int idx){
        if(idx == cctvList.size()){
            answer = Math.min(answer, calculate());
            return;
        }
        for(int[] dir : makeDirection(cctvList.get(idx).num)) {
            for(int d : dir){
                move(d, cctvList.get(idx).x, cctvList.get(idx).y, -1);
            }

            back_tracking(idx + 1);

            for(int d : dir){
                move(d, cctvList.get(idx).x, cctvList.get(idx).y, 1);
            }
        }
    }

    private static int calculate(){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(office[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    private static void move(int d,int x, int y, int k){
        int nx = x + dir[d][0];
        int ny = y + dir[d][1];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M && office[nx][ny] != 6) {
            if(office[nx][ny] == 6){
                break;
            }
            if(office[nx][ny] == 0 || office[nx][ny] == 1){
                office[nx][ny] += k;
            }
            nx += dir[d][0];
            ny += dir[d][1];
        }
    }

    private static List<int[]> makeDirection(int cctvNum){
        List<int[]> directions = new ArrayList<>();

        switch (cctvNum) {
            case 1:
                directions.add(new int[]{UP});
                directions.add(new int[]{DOWN});
                directions.add(new int[]{LEFT});
                directions.add(new int[]{RIGHT});
                break;
            case 2:
                directions.add(new int[]{UP, DOWN});
                directions.add(new int[]{LEFT, RIGHT});
                break;
            case 3:
                directions.add(new int[]{UP, RIGHT});
                directions.add(new int[]{RIGHT, DOWN});
                directions.add(new int[]{DOWN, LEFT});
                directions.add(new int[]{LEFT, UP});
                break;
            case 4:
                directions.add(new int[]{UP,LEFT,RIGHT});
                directions.add(new int[]{UP,RIGHT,DOWN});
                directions.add(new int[]{RIGHT,DOWN,LEFT});
                directions.add(new int[]{DOWN,LEFT,UP});
                break;
            case 5:
                directions.add(new int[] {UP,RIGHT,LEFT, DOWN});
                break;
        }

        return directions;
    }

    public static void main(String[] args) throws IOException {
        new BOJ15683().solution();
    }

}
