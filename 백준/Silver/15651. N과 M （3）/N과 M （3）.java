import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N,M; // 1부터 N까지 자연수 중에서 중복 없이 M개 고른 수열
    private static List<int[]> answer = new ArrayList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        comb(0, 0, new boolean[N], new int[M]);

        for(int i = 0; i < answer.size(); i++) {
            for(int j = 0; j < answer.get(i).length; j++) {
                sb.append(answer.get(i)[j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void comb(int start, int depth, boolean[] visited, int[] arr) {
        if(depth == M) {
            answer.add(arr.clone());
            return;
        }

        for(int i = 0; i < N; i++) {
                visited[i] = true;
                arr[depth] = i + 1;
                comb(i, depth+1, visited, arr);
                visited[i] = false;
            }
        }
    }


