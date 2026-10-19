import java.util.*;

// 1이상 4이하의 정수로만 이루어져 있음
// 정확히 해당 숫자만큼 연달아 같은 숫자가 나오는 수를 아름다운 수 라고 부름.
// N은 자릿수
public class Main {
    static List<Integer> seq;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        seq = new ArrayList<>();
        answer = 0;

        backtracking(n, 0);

        System.out.println(answer);
    }


    private static void backtracking(int n, int count) {
        if(n == count) {
            if(isBeautiful(n)) {
                answer++;
            }
            return;
        }

        for(int i = 1; i <= 4; i++) {
            seq.add(i);
            backtracking(n, count + 1);
            seq.remove(seq.size() - 1);
        }
    }

    private static boolean isBeautiful(int n) {
        for(int i = 0; i < n; i += seq.get(i)) {
            int now = seq.get(i);

            if(i + now - 1 >= seq.size()) return false;

            for(int j = i; j < i + now; j++) {
                if(seq.get(j) != now) {
                    return false;
                }
            }
        }
        return true;
    }
}