package september.fourteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14225 {
    private static int N;
    private static int[] sequence;
    private static Set<Integer> candidates = new TreeSet<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        makeSet(0,0);

        int answer = 1;
        while(candidates.contains(answer)){
            answer++;
        }
        System.out.println(answer);
    }

    private static void makeSet(int count, int tempSum) {
        if(count == N){
            if(tempSum > 0) {
                candidates.add(tempSum);
            }
            return;
        }
        makeSet(count + 1, tempSum + sequence[count]);
        makeSet(count + 1, tempSum);

    }
}
