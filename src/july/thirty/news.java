package july.thirty;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class news {
    private static List<Integer>[] tree;
    private static int[] dp;
    private static int n;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        // 민식이의 회사는 트리 구조
        // 모든 직원은 정확하게 한명의 직속 상사가 있다.
        // 모든 직원은 민식이의 직접 또는 간접적인 부하 => 대가리가 민식이
        // 뉴스가 전달될건데, 민식이가 전달하면 각 부하가 지네 부하한테 전달 => 모든 사람이 뉴스 들을 때 까지
        // 모든 사람은 자신의 부하한테만 걸 수 있고 (링크 연결), 전화는 정확히 1분
        // 구 ) 모든 직원이 소식을 듣는데 걸리는 시간의 최솟값

        int N = Integer.parseInt(br.readLine());
        dp = new int[n];
        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 1; i < n; i++) {
            tree[Integer.parseInt(st.nextToken())].add(i);
        }
        bw.write(String.valueOf(dfs(0)));
        bw.flush();
    }
    private static int dfs(int cur) {
        int cnt = 0;
        int max = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int next : tree[cur]) {
            dp[next] = dfs(next);
            q.add(new int[]{next, dp[next]});
        }
        while (!q.isEmpty()) {
            int[] node = q.poll();
            cnt++;
            max = Math.max(max, node[1] + cnt);
        }
        return max;
    }
}

/**
 tree에 인덱스가 상사의 번호인 부분에 1부터 순서대로 숫자를 집어 넣는다.
 그 후 dfs라는 함수를 돌린다.
 tree의 인덱스 0부터 다 가져와 dp의 가져온 int형식의 번호 마다의 최댓값을 재귀함수를 통해 구한다.
 그 후 q라는 우선순위 큐에 next, dp[next]를 넣는다.
 번호와 그에 대한 최댓값을 넣는다.
 q에서 최댓값이 가장 큰 부분(가장 전파가 오래걸리는 부분) 부터 하나씩 가져와 cnt를 더한 값과 max와 비교해 최댓값을 저장한다.
 cnt는 1씩 늘려준다.(직속 부하에게 전화를 거는데 걸리는 시간) 최종적으로 dfs(0) 을 호출했던 값을 출력하면된다.
 **/


