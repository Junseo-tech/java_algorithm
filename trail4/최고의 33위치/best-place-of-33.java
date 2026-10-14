import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int temp = countOne(i, j, n, grid);
                if(answer < temp) {
                    answer = temp;
                }
            }
        }

        System.out.println(answer);
    }

    private static int countOne(int x, int y, int n, int[][] grid) {
        int endX = x + 3;
        int endY = y + 3;
        int count = 0;
        if(endX > n || endY > n) {
            return 0;
        }

        for(int i = x; i < endX; i++) {
            for(int j = y; j < endY; j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}