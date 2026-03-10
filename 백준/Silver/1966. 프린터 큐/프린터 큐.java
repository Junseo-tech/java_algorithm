import java.io.*;
import java.util.*;

// 인덱스 0부터 시작하고, 궁금한 것의 인덱스 번호가 주어진다
// 중요도가 더 높은 것이 있다면 빼서 뒤에 넣는다.
// 중요도가 비슷한 것이 여러개 나올 수 있다. 초기 순서를 기억해야 한다.

class Page {
    int importance;
    int idx;

    public Page(int importance, int idx) {
        this.importance = importance;
        this.idx = idx;
    }

}

public class Main {
    private static Queue<Page> pages;
    private static PriorityQueue<Integer> importances;
    private static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t= 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 현재에 몇 번째에 놓여있는지. 인덱스 0부터 시작함.

            pages = new LinkedList<>();
            importances = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int imp = Integer.parseInt(st.nextToken());
                pages.add(new Page(imp, i));
                importances.add(imp);
            }

            sb.append(printOrder(M)).append("\n");
        }

        System.out.println(sb);
    }

    private static int printOrder(int M) {
        int count = 1;

        while(!pages.isEmpty()) {
            Page tempPage = pages.poll(); // (1,0)  (2, 1)  (3, 2)
            int tempMax = importances.poll(); // 4   4

            if(tempPage.idx == M && tempPage.importance == tempMax) return count;
            if(tempPage.importance < tempMax) {
                pages.add(tempPage); // [페이지] 2 3 4 1    [페이지] 3 4 1 2
                importances.add(tempMax); // [중요도] 4 3 2 1
            }
            if(tempPage.importance == tempMax) count++; // 2 3
        }

        return count;
    }
}