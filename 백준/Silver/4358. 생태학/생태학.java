import java.util.*;
import java.io.*;

public class Main {
    private static Map<String, Integer> trees;
    private static int total;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        trees = new TreeMap<>(); // 정렬이 필요하니까 트리맵
        String tree;
        total = 0;
        StringBuilder sb = new StringBuilder();

        while((tree = br.readLine()) != null) {
            total++;
            trees.merge(tree, 1, Integer::sum); // key가 없으면 1 있으면 기존 값에 1 더하기
        }

        for(Map.Entry<String, Integer> entry : trees.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", (float) entry.getValue() * 100 / total)).append("\n");
        }

        System.out.println(sb);
    }
}