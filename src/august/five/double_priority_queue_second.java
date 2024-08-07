package august.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class double_priority_queue_second {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i < N; i++){
                String[] input = br.readLine().split(" ");
                char ch = input[0].charAt(0);
                int num = Integer.parseInt(input[1]);
                if(ch == 'I'){
                    tMap.put(num, tMap.getOrDefault(num, 0) + 1);
                } else {
                    if(tMap.isEmpty()) continue;
                    if (num == -1){
                        int min = tMap.firstKey();
                        if(tMap.get(min) == 1){
                            tMap.remove(min);
                        } else {
                            tMap.put(min, tMap.get(min) - 1);
                        }
                    } else {
                        int max = tMap.lastKey();
                        if(tMap.get(max) == 1){
                            tMap.remove(max);
                        } else {
                            tMap.put(max, tMap.get(max) - 1);
                        }
                    }
                }
            }
            if(tMap.isEmpty()){
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(tMap.lastKey()).append(" ").append(tMap.firstKey()).append("\n");
            }
            System.out.print(sb);
        }

    }
}
