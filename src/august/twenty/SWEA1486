package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1486 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N,B;
	private static int[] tall; 
	private static int min;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			tall = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				tall[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			
			makeHeight(0, 0);
			
			sb.append("#").append(t).append(" ").append(Math.abs(min - B)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	private static void makeHeight(int count , int sum) {
		if(sum >= B) {
			min = Math.min(min, sum);
			return;
		}
		if(count == N) {
			return;
		}
		
		makeHeight(count + 1, sum + tall[count]);
		makeHeight(count + 1, sum);
	}
}
