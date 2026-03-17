import java.util.*;
import java.io.*;

public class Main {
    private static int N,M;
    private static int[] nums;
    private static List<int[]> answer;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N 까지
        M = Integer.parseInt(st.nextToken()); // M개 고르기
        answer = new ArrayList<>();

        nums = new int[N+1];

        for(int i = 1; i<=N; i++) {
            nums[i] = i;
        }

        permutation(0, new boolean[N + 1], new int[M]);
        StringBuilder sb = new StringBuilder();
        for(int[] temp : answer) {
            for(int num : temp) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void permutation(int depth, boolean[] visited, int[] temp) {
        if(depth == M) {
            answer.add(temp.clone());
            return;
        }
        for(int i = 1; i <= N; i++) {
           if(!visited[i]) {
                visited[i] = true;
                temp[depth] = nums[i];
                permutation(depth + 1, visited, temp);
                visited[i] = false;
           }
        }
    }

}
