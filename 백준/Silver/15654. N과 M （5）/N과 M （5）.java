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

        permutation(0, new boolean[N], new int[M]);
        System.out.println(sb.toString());
    }

    private static void permutation(int depth, boolean[] visited, int[] temp) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(temp[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                permutation(depth+1, visited, temp);
                visited[i] = false;
            }
        }
    }
}
