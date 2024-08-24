package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static int[][] customers;
	private static int company_x, company_y, home_x, home_y;
	private static int min;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			customers = new int[N][2];
			
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			company_x = Integer.parseInt(st.nextToken());
			company_y = Integer.parseInt(st.nextToken());
			home_x = Integer.parseInt(st.nextToken());
			home_y = Integer.parseInt(st.nextToken());
				
			
			for(int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0,new boolean[N], company_x, company_y);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	
	private static void dfs(int depth, int currentSum, boolean[] visited, int x, int y) {
		if(currentSum >= min) {
			return;
		}
		if(depth == N) {
			currentSum += Math.abs(x - home_x) + Math.abs(y - home_y);
			min = Math.min(min, currentSum);
			return;
		}
		
		else {
			for(int i = 0; i < N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					int newSum = currentSum + Math.abs(customers[i][0] - x) + Math.abs(customers[i][1] - y);
					dfs(depth + 1, newSum, visited, customers[i][0], customers[i][1]);
					visited[i] = false;
				}
			}
		}
	}

}
