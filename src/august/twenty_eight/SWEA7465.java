package august.twenty_eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA7465 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M;
    private static int[] parent;
    private static Set<Integer> people = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N];
            for(int i = 0; i < N; i++) {
                parent[i] = i;
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                union(a, b);
            }

            for(int i = 0; i < N; i++) {
                people.add(find(parent[i]));
            }

            sb.append(people.size()).append("\n");
            people.clear();
        }

        System.out.println(sb);

    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) {
            if(x < y) parent[y] = x;
            else if(y < x) parent[x] = y;
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
