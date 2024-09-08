package september.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16562 {
    private static int N,M,k;
    private static int[] money;
    private static int[] parents;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Set<Integer> visited = new HashSet<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        money = new int[N];
        parents = new int[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            union(a, b);
        }

        for (int i = 0; i < N; i++) {
            visited.add(find(i));
        }

        int temp = 0;
        for(int t : visited){
            temp += money[t];
        }

        if(temp > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(temp);
        }
    }

    static int find(int v){
        if(parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if(money[parentA] < money[parentB]) parents[parentB] = parentA;
        else parents[parentA] = parentB;
    }

}
