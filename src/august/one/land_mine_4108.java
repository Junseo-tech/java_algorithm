package august.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class land_mine_4108 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {-1,0,1,0,-1,1,1,-1};
    static int[] dy = {0,-1,0,1,1,1,-1,-1};
    private static int[][] answer;
    public static void main(String[] args) throws IOException {
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            answer = new int[n][m];
            if(n==0 && m==0){
                break;
            }
            char[][] map = new char[n][m];
            for(int i=0;i<n;i++){
                String line = br.readLine();
                for(int j=0;j<m;j++){
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == '*'){
                        answer[i][j] = -1;
                    }
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j] == '*'){
                        bfs(i,j,n,m);
                    }

                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if (answer[i][j] == -1) {
                        sb.append('*');
                    } else {
                        sb.append(answer[i][j]);
                    }
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }


    }
    private static void bfs(int x , int y, int n, int m){
        for(int i=0;i<8;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<m && answer[nx][ny] != -1){
                answer[nx][ny] += 1;
            }
        }
    }

}
