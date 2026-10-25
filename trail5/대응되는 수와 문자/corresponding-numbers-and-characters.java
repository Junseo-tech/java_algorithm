import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[] words = new String[N + 1];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            words[i] = br.readLine();
            map.put(words[i], i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String query = br.readLine();

            // 숫자이면 번호에 대응하는 문자열을 출력한다.
            if (Character.isDigit(query.charAt(0))) {
                sb.append(words[Integer.parseInt(query)]).append('\n');
            } else {
                // 문자열이면 대응하는 번호를 출력한다.
                sb.append(map.get(query)).append('\n');
            }
        }

        System.out.print(sb);
    }
}