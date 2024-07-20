import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_plus_B_6 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String line = br.readLine();
            String[] part = line.split(",");
            int A = Integer.parseInt(part[0]);
            int B = Integer.parseInt(part[1]);
            sb.append(A+B).append("\n");
        }
        System.out.println(sb.toString());
    }
}
