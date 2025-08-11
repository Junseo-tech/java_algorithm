import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static char[][] cookie;
    private static int[] dx = new int[]{0, 0, 1, -1, 1, 1};
    private static int[] dy = new int[] {-1, 1, 0, 0, -1, 1};
    private static boolean[][] visited;
    private static int sinjoX, sinjoY;
    private static int waistX, waistY;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cookie = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++) {
                cookie[i][j] = line.charAt(j);
            }
        }

        findSinjo();

        StringBuilder sb = new StringBuilder();
        sb.append(sinjoX + 1).append(" ").append(sinjoY + 1).append("\n");
        for(int i = 0; i < 3; i++) {
            int length = calculate(i, sinjoX, sinjoY, 0);
            sb.append(length).append(" ");
        }

        int legLeftX = waistX + dx[4];
        int legLeftY = waistY + dy[4];
        int legRightX = waistX + dx[5];
        int legRightY = waistY + dy[5];


        int leftLeg = calculate(2, legLeftX, legLeftY, 1);
        int rightLeg = calculate(2,legRightX,legRightY, 1);

        sb.append(leftLeg).append(" ").append(rightLeg);

        System.out.println(sb);

    }

    private static void findSinjo() {
        for(int i =0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(cookie[i][j] == '*') {
                    int count = 0;
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if(cookie[nx][ny] == '*') count++;
                        }
                    }

                    if(count == 4) {
                        sinjoX = i; //위 아래
                        sinjoY = j;
                        return;
                    }
                }
            }
        }
    }

    private static int calculate(int d, int x, int y, int length) {
        while(cookie[x][y] == '*') {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;

            if(cookie[nx][ny] == '*') {
                x = nx;
                y = ny;
                length++;
            } else {
                if(d == 2) {
                    waistX = x;
                    waistY = y;
                }
                break;
            }

        }

        return length;
    }
}
