import java.util.*;
import java.io.*;

// 준현 => 살 수 있으면 무조건 최대한 많이 삼
// 성민 =>  전량 매수 및 전량 매도. 빚은 안냄. 3일 연속 상승하면 전량 매도. 같으면 상승 ㄴㄴ. 3일 연속 하락하면 상승. 전량 매수
// 구) 누가 더 높은 수익률을 낼 지 맞춰라.
public class Main {
    private static int[] stock;
    private static final String JUNHYEON = "BNP";
    private static final String SUNGMIN = "TIMING";
    private static final String SAME = "SAMESAME";
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {

        int beginCash = Integer.parseInt(br.readLine());

        stock = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stock[i] = Integer.parseInt(st.nextToken());
        }

        int jun = checkJunhyeon(beginCash);
        int sung = checkSungMin(beginCash);

        if (jun < sung) {
            System.out.println(SUNGMIN);
        } else if(jun > sung) {
            System.out.println(JUNHYEON);
        } else {
            System.out.println(SAME);
        }

    }

    private static int calculate(int cash, int stockCount) {
        return cash + stockCount * stock[13];
    }

    private static int checkJunhyeon(int beginCash) {
        int stockCount = 0;
        int cash = 0;
        for(int i = 0; i < 14; i++) {
            stockCount += beginCash / stock[i];
            cash = beginCash % stock[i];
            beginCash = cash;
        }
        return calculate(beginCash, stockCount);
    }

    private static int checkSungMin(int beginCash) {
        int stockCount = 0;
        int cash = 0;
        int start = 0;

        boolean isPreDimish = true;
        boolean isPreIncrease = true;

        while(true) {
            int diminish = 0;
            int increase = 0;

            for(int i=start; i < start + 3; i++) {
                if (stock[i] > stock[i + 1]) {
                    diminish++;
                } else if(stock[i] < stock[i + 1] ) {
                    increase++;
                }
            }

            if(diminish == 3) {
                stockCount += beginCash / stock[start + 3];
                cash = beginCash % stock[start + 3];
                beginCash = cash;
            }

            if(increase == 3 && stockCount > 0) {
                cash += stock[start + 3] * stockCount;
                stockCount = 0;
                beginCash = cash;
            }

            start++;
            if(start == 11) return calculate(beginCash, stockCount);

        }

    }
}
