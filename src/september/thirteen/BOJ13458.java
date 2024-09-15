import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static int[] test;
	private static int B,C;
	private static long answer;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		test = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			test[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		setSuperVisor();
		System.out.println(answer);
	}
	
	
	private static void setSuperVisor() {
		for(int i = 0; i < N; i++) {
			test[i] -= B;
			answer++;
			
			if(test[i] > 0) {
				answer += (test[i] + C - 1) / C;
			}
		}
	}
}
