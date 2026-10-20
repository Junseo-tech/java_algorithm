import java.util.*;
import java.io.*;

public class Main {
    static TreeSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int[] queries = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            queries[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num : queries) {
            Integer temp = set.floor(num);
            if(temp != null) {
                sb.append(temp).append("\n");
                set.remove(temp);
            } else {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);

    }
}