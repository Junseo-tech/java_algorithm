import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 접근법을 모르겠어서 문제 읽고 얼마 안지나서 답 봄
* 초기 고민 : 무한히를 어떻게 구현 할 것인가 ? 어쨌든 종료 시점이 있을 건데
* 90도로 회전하는 특성상 상/하/좌/우 가 가장 작은 cycle이다. 하나의 사이클이 가능한 4번을 돌았을 때
* 방향이 초기 방향과 동일한 방향이라면, 이는 멀어지는 방향이므로 최대 거리가 무한대가 나올 수 밖에 없다.
* */
public class Solution {
    private static String command;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,-1,0,1};
    private static int answer;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            command = br.readLine();
            answer = 0;
            int now = move();
            if(now == 1) {
                sb.append(answer).append("\n");
            } else {
                sb.append("oo").append("\n");
            }
        }
        System.out.println(sb);

    }

    private static int move() {
        int nowX = 0;
        int nowY = 0;
        int dir = 3;
        int startDir = dir;
        for(int i = 0; i < 4; i++) {
            int[] temp = takeCommand(nowX, nowY, dir);

            nowX = temp[0];
            nowY = temp[1];
            dir = temp[2];
        }
            if(nowX == 0 && nowY == 0) {
                return 1;
            }


        if(startDir == dir) {
            return -1;
        }

        return 1;
    }

    private static int[] takeCommand(int x, int y, int dir) {
        int[] temp = new int[3];
        for(int i = 0; i < command.length(); i++) {
            if(command.charAt(i) == 'S') {
                x += dx[dir];
                y += dy[dir];
                double dis = Math.pow(x - 0, 2) + Math.pow(y - 0, 2);
                answer = (int) Math.max(answer, dis);
            } else if(command.charAt(i) == 'L') {
                dir = (dir + 1) % 4;
            } else if(command.charAt(i) == 'R') {
                dir = (dir + 3) % 4;
            }
        }
        temp = new int[]{x,y, dir};
        return temp;
    }
}