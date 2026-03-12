import java.util.*;
import java.io.*;

// 도감에서 포켓몬 이름을 보면 포켓몬 번호를 말하거나, 번호를 말하면 이름을 말하는 연습
public class Main {
    private static int N; // 1 <= N <= 100,000
    private static int M; // 1 <= M <= 100,000
    private static Map<String, Integer> nameBook;
    private static Map<Integer, String> numBook;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nameBook = new HashMap<String, Integer>();
        numBook = new HashMap<Integer, String>();

        for(int i = 1; i <= N; i++) {
            String pocket = br.readLine();
            nameBook.put(pocket, i);
            numBook.put(i, pocket);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            String question = br.readLine();

            char first = question.charAt(0);
            if(Character.isDigit(first)) {
                int num = Integer.parseInt(question);
                sb.append(numBook.get(num)).append("\n");
            } else {
                sb.append(nameBook.get(question)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
