package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static int company_x, company_y, home_x, home_y;
	private static int[][] customers;
	private static int min;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			customers = new int[N][N];
			
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			company_x = Integer.parseInt(st.nextToken());
			company_y = Integer.parseInt(st.nextToken());
			home_x = Integer.parseInt(st.nextToken());
			home_y = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++) {
				customers[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			}
			
			dfs(0, new boolean[N], new int[N]);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");

		}
		
		System.out.println(sb);
	}
	
	private static void dfs(int depth, boolean[] visited, int[] per) {
		if(depth == N) {
			findPath(per);
			return;
		} else {
			for(int i = 0; i < N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					per[depth] = i;
					dfs(depth + 1, visited, per);
					visited[i] = false;
				}
			}
		}
	}
	
	private static void findPath(int[] per) {
		int company_distance = Math.abs(customers[per[0]][0] - company_x) + Math.abs(customers[per[0]][1] - company_y);
		int house_distance = 0;
		for(int i = 1; i < N; i++) {
			house_distance +=  Math.abs(customers[per[i-1]][0] - customers[per[i]][0]) + Math.abs(customers[per[i-1]][1] - customers[per[i]][1]);
		}
		int end = per[N-1];
		int home_distance = Math.abs(home_x - customers[end][0]) + Math.abs(home_y - customers[end][1]);
		int total = home_distance + company_distance + house_distance;
		min = Math.min(min, total);
	}

}
