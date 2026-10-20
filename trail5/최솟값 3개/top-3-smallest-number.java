import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
            if(pq.size() < 3) {
                sb.append(-1).append("\n");
            } else {
                long count = 1;
                int[] tempArr = new int[3];
                for(int j = 0; j < 3; j++) {
                    int temp = pq.poll();
                    count *= temp;
                    tempArr[j] = temp;
                }
                for(int j = 0; j < 3; j++) {
                    pq.add(tempArr[j]);
                }
                sb.append(count).append("\n");
            }
        }

        System.out.print(sb);


    }
}