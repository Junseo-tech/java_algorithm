import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int R,C;
	private static char[][] maps;
	private static int[] dx = {-1, 0, 1};
	private static int[] dy = {1,1,1};
	private static boolean[][] visited;
	private static int count;
	private static int answer;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		maps = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				maps[i][j] = input.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			if(dfs(i, 0)) {
				count++;
				//System.out.println("count : " + count + " i : " + i);
			}
		}
		
		System.out.println(count);
	}
	
	private static boolean dfs(int x, int y) { // 1 0, 2 0, 3 0, 4 0......
		if(y == C-1) {
			return true;
		} else { 
			for(int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < R && ny < C && maps[nx][ny] == '.' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(dfs(nx,ny)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
