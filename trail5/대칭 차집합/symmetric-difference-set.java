import java.util.*;
import java.io.*;

// 대칭 차집합 원소의 개수 
public class Main {
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            // A[i] = Integer.parseInt(st.nextToken());
            set.add(Integer.parseInt(st.nextToken()));
        }
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            // B[i] = Integer.parseInt(st.nextToken());
            int temp = Integer.parseInt(st.nextToken());
            if(set.contains(temp)) {
                set.remove(temp);
            } else {
                set.add(temp);
            }
            
        }
        
        System.out.println(set.size());
        
    }
}