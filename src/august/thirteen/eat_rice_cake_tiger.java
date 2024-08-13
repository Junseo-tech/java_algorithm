package august.thirteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class eat_rice_cake_tiger {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int D,K;
    private static int[] riceCake;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        countRiceCake();

    }

    private static void countRiceCake(){
        for(int i = 1; i <= 100000; i++){
            for(int j = 1; j <= 100000; j++){
                riceCake = new int[D+1];
                riceCake[1] = i;
                riceCake[2] = j;

                for(int e = 3; e <= D; e++){
                    riceCake[e] = riceCake[e-1] + riceCake[e-2];
                }

                if(riceCake[riceCake.length-1] == K){
                    System.out.println(riceCake[1]);
                    System.out.println(riceCake[2]);
                    return;
                }
            }
        }

    }
}
