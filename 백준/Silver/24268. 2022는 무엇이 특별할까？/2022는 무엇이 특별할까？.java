import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N보다 크면서 d진법으로 표현했을 때 d진법의 숫자가 모두 정확히 한번씩 등장하는 가장 작은 수 찾기. 앞에 0있으면 안됨
// N => 10^9 , 2 <= d <= 9
public class Main {
    private static int N, d;
    private static int[] num;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean isExist;
    private static long answer;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        num = new int[d];
        answer = -1;

        for(int i = 0; i < d; i++) {
            num[i] = i;
        }

        //isExist = false;
        findNum(new boolean[d], "");
        System.out.println(answer);

    }

    private static void findNum(boolean[] visited, String temp) {
        if(temp.length() == d) {
            Long value = Long.parseLong(temp, d);
            if(value > N) {
                answer = value;
                System.out.println(answer);
                System.exit(0);
            }
            return;
        }

        for(int i = 0; i < d; i++) {
            if(temp.isEmpty() && i == 0) continue;
            if(!visited[i]) {
                visited[i] = true;
                findNum(visited, temp + num[i]);
                visited[i] = false;
            }
        }
    }
}
