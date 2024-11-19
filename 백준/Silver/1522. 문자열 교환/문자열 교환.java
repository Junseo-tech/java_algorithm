import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 슬라이딩 윈도우 문제인 것은 봤는데 윈도우 크기 설정을 어떻게 하지? 를 많이 고민함
 * 결국 블로그에서 힌트 얻어버림.. 근데 이제 개빠른 시간에 얻어버림.. 좀 더 생각하려고 하는 습관이 부족한듯
 * 핵심 로직
 * a의 갯수를 세어서 그 것을 윈도우의 크기로 삼고, 쭉 돌면서 ( 원형이니까 순환하게 ) b의 갯수를 세어서 최소 값을 구한다.
 * 
 * */
public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String str;
	private static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		str = br.readLine();
		
		int aCount = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a') {
				aCount++; // 창문 길이 지정 해준다
			}
		}
		
		
		for(int i = 0; i < str.length(); i++) {
			int bCount = 0;
			for(int j = i; j < i + aCount; j++) {
				if(str.charAt(j % str.length()) == 'b') {
					bCount++;
				}
			}
			answer = Math.min(answer, bCount);
		}
		
		System.out.println(answer);
	}

}