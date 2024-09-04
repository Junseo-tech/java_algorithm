import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1494 {

    static class Snail{
        long x,y;

        public Snail(long x, long y) {
            super();
            this.x = x;
            this.y = y;
        }

    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static Snail[] snails;
    private static long min;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            snails = new Snail[N];
            min = Long.MAX_VALUE;
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                snails[i] = new Snail(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            }
            back_tracking(0, 0 , new boolean[N]);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void back_tracking(int count, int start, boolean[] visited) { // 조합
        if(count == N / 2) {
            long nx = 0;
            long ny = 0;
            for(int i = 0; i < N; i++) {
                if(visited[i]) {
                    nx += snails[i].x;
                    ny += snails[i].y;
                } else {
                    nx -= snails[i].x;
                    ny -= snails[i].y;
                }
            }
            min = Math.min(min, nx * nx + ny * ny);
            return;
        }
        for(int i = start; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                back_tracking(count + 1, i + 1, visited);
                visited[i] = false;
            }
        }
    }

}
