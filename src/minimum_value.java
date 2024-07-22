import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class minimum_value {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;
    private static int[] tree;
    public static void main(String[] args) throws IOException, NumberFormatException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        tree = new int[N * 4]; // 4배로 정의
        makeMinTree(1,N,1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            sb.append(findMin(1, N, 1, left, right)).append("\n");
        }

        System.out.println(sb);
    }

    private static int makeMinTree(int start, int end, int node){
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = Math.min(makeMinTree(start, mid, 2 * node), makeMinTree(mid+1, end, 2*node+1)); // 1부터 시작이니까
    }

    private static int findMin(int start, int end, int node, int left, int right) {
        if(right < start || left > end) { // 범위 벗어 났을 때
            return Integer.MAX_VALUE;
        }

        if (left <= start && right >= end){
            return tree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(findMin(start, mid, node * 2, left, right), findMin(mid + 1, end, node * 2 + 1, left, right));
    }
}
