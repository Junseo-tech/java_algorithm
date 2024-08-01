package july.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class remain {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int first = (A+B)%C;
        int second = ((A%C) + (B%C))%C;
        int third = (A*B)%C;
        int fourth = ((A%C) * (B%C))%C;

        StringBuilder sb = new StringBuilder();
        sb.append(first).append("\n").append(second).append("\n").append(third).append("\n").append(fourth);
        System.out.println(sb);
    }
}
