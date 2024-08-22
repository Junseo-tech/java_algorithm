package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1861 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static int[][] rooms;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int answer;
	private static int num;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			rooms = new int[N][N];
			
			answer = 0;
			num = 0;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				int count = 0;
				for(int j = 0; j < N; j++) {
					count = bfs(i, j, new boolean[N][N], 1);
					if(answer < count) {
						num = rooms[i][j];
						answer = count;
					} else if(answer == count) {
						num = Math.min(num, rooms[i][j]);
					
					}
				}
			}
			sb.append("#").append(t).append(" ").append(num).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int bfs(int x, int y, boolean[][] visited, int count) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int temp_x = temp[0];
			int temp_y = temp[1];
			for(int i = 0; i < 4; i++) {
				int nx = temp_x + dx[i];
				int ny = temp_y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && rooms[temp_x][temp_y] + 1 == rooms[nx][ny]) {
					visited[nx][ny] = true;
					count++;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		return count;
	}

}
