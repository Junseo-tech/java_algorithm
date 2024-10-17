import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Solution {
	static class stemCell {
		int x, y , force, time, state, temp;
		public stemCell(int x, int y, int force, int time, int state) {
			super();
			this.x = x;
			this.y = y;
			this.force = force;
			this.time = time;
			this.state = state;
		}
		
	}
	private static final int DEAD = 0, ACTIVE = 1, INACTIVE = 2;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static List<stemCell> medium;
	private static PriorityQueue<stemCell> queue;
	private static boolean[][] visited;
	private static int N,M,K;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			medium = new ArrayList<>();
			queue = new PriorityQueue<>((o1, o2) -> o2.force - o1.force);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N + 2 * K][M + 2 * K];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n != 0) {
						medium.add(new stemCell(i + K, j + K, n, n, INACTIVE));
						visited[i + K][j + K] = true;
					}
				}
			}
			culture();
			int answer = count();
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void culture() {
		for(int k = 1; k <= K; k++) {
			while(!queue.isEmpty()) {
				stemCell cell = queue.poll();
				if(!visited[cell.x][cell.y]) {
					visited[cell.x][cell.y] = true;
					medium.add(cell);
				}
			}
			
			for(int i = 0; i < medium.size(); i++) {
				if(medium.get(i).state == DEAD) continue;
				
				else if(medium.get(i).state == INACTIVE && medium.get(i).time == k) {
					medium.get(i).state = ACTIVE;
					medium.get(i).time = k + medium.get(i).force;
					
					for(int d = 0; d < 4; d++) {
						int nx = medium.get(i).x + dx[d];
						int ny = medium.get(i).y + dy[d];
						
						if(!visited[nx][ny]) {
							queue.add(new stemCell(nx, ny, medium.get(i).force, medium.get(i).time + 1, INACTIVE));
						}
					}
				} else if(medium.get(i).state == ACTIVE && medium.get(i).time == k) {
					medium.get(i).state = DEAD;
				}
			}
		}
	}
	
	private static int count() {
		int count = 0;
	    for (stemCell cell : medium) {
	        if (cell.state == INACTIVE || cell.state == ACTIVE) {
	            count++;
	        }
	    }
	    return count;
	}
}