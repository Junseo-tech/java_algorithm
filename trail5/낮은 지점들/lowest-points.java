import java.util.*;
import java.io.*;

// N개의 점이 주어졌을 때 동일한 x 좌표를 갖는 점들에 대해서는 그 중 가장 작은 y값만 남겨 놓음
public class Main {
    static HashMap<Long, Long> map;
    public static void main(String[] args) throws IOException {
        map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = (long) Integer.parseInt(st.nextToken());
            long y = (long) Integer.parseInt(st.nextToken());

            if(!map.containsKey(x)) {
                map.put(x, y);
            } else {
                if(map.get(x) > y) {
                    map.put(x, y);
                }
            }
        }
        
        long count = 0;
        for(Map.Entry<Long, Long> m : map.entrySet()) {
            count += m.getValue();
        }

        System.out.println(count);
    }
}