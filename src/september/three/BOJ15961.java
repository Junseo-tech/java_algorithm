package september.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15961 {
    private static int N,d,k,c;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] sushi;
    private static int[] choice;
    private static int count = 0;
    private static int maxSushi = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥의 가지 수
        k = Integer.parseInt(st.nextToken()); // 연속 해서 먹는 거 -> 창의 넓이
        c = Integer.parseInt(st.nextToken()); // 쿠폰

        sushi = new int[N];
        choice = new int[d + 1];

        choice[c] = 1;

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < k; i++){
            choice[sushi[i]] += 1;
            if(choice[sushi[i]] == 1){
                count += 1;
            }
        }

        sliding_window();
        System.out.println(maxSushi + 1);

    }
    private static void sliding_window(){
        for(int i = 0; i < N; i++){
            choice[sushi[i]] -= 1;
            if(choice[sushi[i]] == 0){
                count -= 1;
            }

            choice[sushi[(i + k) % N]] += 1;
            if(choice[sushi[(i + k) % N]] == 1){
                count += 1;
            }

            maxSushi = Math.max(maxSushi, count);
        }
    }
}
