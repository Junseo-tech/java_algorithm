import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Word implements Comparable<Word> {
        String alpha;
        int length;
        int count;

        public Word(String alpha, int length, int count) {
            this.alpha = alpha;
            this.length = length;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            if(this.count != o.count) {
                return o.count - this.count;
            }

            if(this.length != o.length) {
                return o.length - this.length;
            }

            return this.alpha.compareTo(o.alpha);
        }
    }

    private static int N,M;
    private static HashMap<String, Integer> words;
    private static List<Word> pq;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pq = new ArrayList<>();
        words = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() < M) continue;
            int count = words.getOrDefault(word, 0);
            words.put(word, count + 1);
        }

        for(Map.Entry<String, Integer> entry : words.entrySet()) {
            String word = entry.getKey();
            Integer count = entry.getValue();

            pq.add(new Word(word, word.length(), count));

        }

        Collections.sort(pq);

        StringBuilder sb = new StringBuilder();

        for(Word word : pq) {
            sb.append(word.alpha).append("\n");
        }

        System.out.println(sb);

    }
}
