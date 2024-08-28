package august.twenty_eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M;
    private static int[] parent;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 집합 개수
            M = Integer.parseInt(st.nextToken()); // 연산 개수

            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken()) -1;
                int b = Integer.parseInt(st.nextToken()) -1;

                if(command == 0){
                    union(a,b);
                } else if(command == 1){
                    boolean same = isSame(a,b);
                    if(same){
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");

        }
        System.out.println(sb);

    }

    private static boolean isSame(int a, int b){
        return find(a) == find(b);
    }

    private static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        if(a == b) return;
        a = find(a);
        b = find(b);
        if(a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
