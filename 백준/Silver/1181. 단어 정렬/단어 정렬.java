import java.util.*;
import java.io.*;

class Word implements Comparable<Word>{
    String word;
    int length;

    public Word(String word, int length) {
        this.word = word;
        this.length = length;
    }

    public int compareTo(Word w) {
        if(this.length != w.length) {
            return this.length - w.length;
        }
        return this.word.compareTo(w.word);
    }
}

public class Main {
    private static int N;
    private static PriorityQueue<Word> pq = new PriorityQueue<>();
    private static Set<String> set = new HashSet<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            set.add(temp);
        }

        for(String s : set) {
            pq.add(new Word(s, s.length()));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < set.size(); i++) {
            sb.append(pq.poll().word).append("\n");
        }

        System.out.println(sb);
    }
}
