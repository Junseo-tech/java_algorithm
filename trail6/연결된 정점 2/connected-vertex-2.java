import java.util.*;
import java.io.*;

// a 정점이 속한 연결 컴포넌트의 크기 출력
// 무수히 많은 정점을 가진 그래프
public class Main {
    static HashMap<Integer, Integer> parent;
    static HashMap<Integer, Integer> size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new HashMap<>();
        size = new HashMap<>();

    
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(union(a, b));
        }
    }

    private static int find(int x) {
        if(!parent.containsKey(x)) {
            parent.put(x, x);
            size.put(x, 1);
            return x;
        }

        if(parent.get(x) == x) return x;

        int root = find(parent.get(x));
        parent.put(x, root);
        return root;
    }

    private static int union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            parent.put(rootY, rootX);
            size.put(rootX, size.get(rootX) + size.get(rootY));
        }

        return size.get(rootX);
    }
}