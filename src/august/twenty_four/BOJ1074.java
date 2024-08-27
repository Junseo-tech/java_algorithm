package august.twenty_four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class BOJ1074 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int r, c;
    private static int count = 0;
    private static int answer;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        makeZ(N, 0, 0);

        System.out.println(answer);
    }

    private static void makeZ(int N, int x, int y){
        if(N == 0){
            if(x == r && y == c){
                answer = count;
            }
            return;
        } else {
            int temp = (int) Math.pow(2, N-1);

            if(r < x + temp && c < y + temp){
                makeZ(N-1,x,y);
            } else if(r < x + temp && c >= y + temp ){
                count += temp * temp;
                makeZ(N-1,x,y + temp);
            } else if(r >= x + temp && c < y + temp){
                count += temp * temp * 2;
                makeZ(N-1,x + temp,y);
            } else {
                count += temp * temp * 3;
                makeZ(N-1,x + temp ,y + temp);
            }
        }
    }
}
