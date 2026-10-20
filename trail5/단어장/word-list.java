import java.util.*;
import java.io.*;

public class Main {
    static TreeMap<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        StringBuilder sb = new StringBuilder(); 
        for(Map.Entry<String, Integer> m : map.entrySet()) {
            sb.append(m.getKey()).append(" ").append(m.getValue()).append("\n");
        }

        System.out.println(sb);

    }
}