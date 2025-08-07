import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static int N, x;
    private static PriorityQueue<Integer> queue = new PriorityQueue<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        // 0 이면 배열에서 가장 작은 값 출력 , 그 값을 배열에서 제거. 정수면 그 값을 넣음
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0 && queue.isEmpty()) sb.append(0).append("\n");
            else if(temp == 0) sb.append(queue.poll()).append("\n");
            if(temp != 0) queue.add(temp);
        }

        System.out.println(sb);

    }

}
