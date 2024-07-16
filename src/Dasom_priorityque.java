import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dasom_priorityque {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 최소힙 -> 최대 힙. 커스터마이징 연습
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
        } else {
            int dasom = Integer.parseInt(br.readLine());
            int[] candidate = new int[N - 1];

            for (int i = 0; i < N - 1; i++) {
                pq.add(Integer.parseInt(br.readLine())); // 루트 노드에 최대값이 담김
            }

            int count = 0;
            while (true) {
                int temp = pq.poll();    // log n
                if (dasom > temp) {
                    System.out.println(count);
                    break;
                }
                temp -= 1;
                dasom += 1;
                count += 1;
                pq.add(temp);        // log n
            }
        }
    }
}
