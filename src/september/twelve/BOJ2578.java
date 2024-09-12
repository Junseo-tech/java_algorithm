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
	public static void main(String[] args) throws IOException {
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				numbers[i * 5 + j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 25; i++) {
			findBingo(i);
		}
		
		for(int i = 0; i < 5; i ++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	private static void findBingo(int findNum) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {2,2});
		boolean[][] tempVisited = new boolean[5][5];
		
		if(bingo[2][2] == findNum) {
			visited[2][2] = true;
			return;
		}
		
		tempVisited[2][2] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int temp_x = temp[0];
			int temp_y = temp[1];
			
			if(bingo[temp_x][temp_y] == findNum) {
				visited[temp_x][temp_y] = true;
				return;
			}
			
			for(int i = 0; i < 8; i++) {
				int nx = temp_x + dx[i];
				int ny = temp_y + dy[i];
				if(0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !tempVisited[nx][ny]) {
					tempVisited[nx][ny] = true;
					queue.add(new int[] {temp_x, temp_y});
				}
			}
		}
	}

}
