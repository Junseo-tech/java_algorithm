import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 개수
        M = Integer.parseInt(st.nextToken()); // 길이

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        combination(0, new int[M], 0);

        System.out.println(sb.toString());
    }

    private static void combination(int depth, int[] temp, int start) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        int prev = 0;
        for(int i = start; i < N; i++) {
            if(arr[i] != prev) {
                temp[depth] = arr[i];
                prev = arr[i];
                combination(depth+1, temp, i);

            }
        }
    }
}
