import java.util.*;
import java.io.*;
  
// 동일한 원소가 연속해서 m개 이상 나오는 구간이 존재 하는지 
public class Main {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answer = 0;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < n; i++) {
            boolean isCol = findHappy(i, n, grid, m);
            boolean isRow = findHappyRow(i, n, grid, m);
            if(isCol) answer++;
            if(isRow) answer++;
        }

        System.out.println(answer);
    }

    private static boolean findHappy(int now, int n, int[][] grid, int m) {
        int temp = 0;
        int count = 1;
        for(int i = 0; i < n; i++) {
            if(grid[now][i] == temp) {
                count++;
            } else {
                count = 1;
            }
            temp = grid[now][i];
            if(count == m) {
                return true;
            }
        }
        return false;
    }
    private static boolean findHappyRow(int now, int n, int[][] grid, int m) {
        int temp = 0;
        int count = 1;
        for(int i = 0; i < n; i++) {
            if(grid[i][now] == temp) {
                count++;
            } else {
                count = 1;
            }

            temp = grid[i][now];
            if(count == m) {
                return true;
            }
        }
        return false;
    }
    
}