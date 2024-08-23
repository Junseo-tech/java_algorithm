package algo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
 
public class SWEA5644 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<List<List<Integer>>> maps = new ArrayList<>();
    private static int[] A;
    private static int[] B;
    private static int[] dx = {0, -1, 0, 1, 0};
    private static int[] dy = {0, 0, 1, 0, -1};
    private static int ten = 10;
     
    private static Map<Integer, Integer> charger = new HashMap<>();
    private static List<List<Integer>> A_power = new ArrayList<>();
    private static List<List<Integer>> B_power = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
     
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int BC = Integer.parseInt(st.nextToken());
             
            A = new int[N];
            B = new int[N];
             
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
             
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
             
            maps = new ArrayList<>();
            for(int i = 0; i <= ten; i++) {
                maps.add(new ArrayList<>());
                for(int j = 0; j < ten; j++) {
                    maps.get(i).add(new ArrayList<>());
                }
            }
             
            charger = new HashMap<>();
            A_power = new ArrayList<>();
            B_power = new ArrayList<>();
             
            for (int i = 0; i <= N; i++) {
                   A_power.add(new ArrayList<>());
                   B_power.add(new ArrayList<>());
            }
             
            for(int b = 1; b <= BC; b++) {
                st = new StringTokenizer(br.readLine());
                int bc_x = Integer.parseInt(st.nextToken())-1; // 내가 평소에 생각하는 y
                int bc_y = Integer.parseInt(st.nextToken())-1; // 내가 평소에 생각하는 x
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                 
                charger.put(b, power);
                 
                for(int i = 0; i < ten; i++) {
                    for(int j = 0; j < ten; j++) {
                        if(Math.abs(bc_x - j) + Math.abs(bc_y - i) <= range) {
                            maps.get(i).get(j).add(b);
                        }
                    }
                }
                 
            }
             
            findPossible(N,0,0,ten-1, ten-1);
             
            sb.append("#").append(tc).append(" ").append(charge(N)).append("\n");
                     
             
        }
        System.out.println(sb);
    }
     
    private static void findPossible(int N, int a_x, int a_y, int b_x, int b_y) {
        if (0 <= a_x && 0 <= a_y && a_x < ten && a_y < ten) {
            A_power.get(0).addAll(maps.get(a_x).get(a_y));
        }
        if (0 <= b_x && 0 <= b_y && b_x < ten && b_y < ten) {
            B_power.get(0).addAll(maps.get(b_x).get(b_y));
        }
         
        for(int i = 1; i <= N; i++) { // A
            a_x += dx[A[i-1]];
            a_y += dy[A[i-1]];
             
            if(0 <= a_x && 0 <= a_y && a_x < ten && a_y < ten) {
                A_power.get(i).addAll(maps.get(a_x).get(a_y));
            }
             
            b_x += dx[B[i-1]];
            b_y += dy[B[i-1]];
            if(0 <= b_x && 0 <= b_y && b_x < ten && b_y < ten) {
                B_power.get(i).addAll(maps.get(b_x).get(b_y));
            }
 
        }
    }
     
    private static int charge(int N) {
        int totalCharge = 0;
        for(int i = 0; i <= N; i++) {
            int maxCharge = 0;
            for(int a : A_power.get(i)) {
                for(int b : B_power.get(i)) {
                    int currentCharge = (a==b) ? charger.get(a) : charger.get(a) + charger.get(b);
                    maxCharge = Math.max(maxCharge, currentCharge);
                }
            }
             
            if(A_power.get(i).isEmpty() && !B_power.get(i).isEmpty()) {
                 for (int b : B_power.get(i)) {
                        maxCharge = Math.max(maxCharge, charger.get(b));
                    }
            }
             
            if (B_power.get(i).isEmpty() && !A_power.get(i).isEmpty()) {
                for (int a : A_power.get(i)) {
                    maxCharge = Math.max(maxCharge, charger.get(a));
                }
            }
             
            totalCharge += maxCharge;
        }
         
        return totalCharge;
    }
}
