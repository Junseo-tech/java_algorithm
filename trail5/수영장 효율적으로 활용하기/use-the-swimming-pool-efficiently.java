import java.util.*;
import java.io.*;

public class Main {
    static int[] times;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        times = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = 0;
        for(int time : times) {
            end += time;
            start = Math.max(start, time);
        }

        System.out.println(binarySearch(start, end));
        
    }

    private static boolean isValid(int mid) {
        int tempLine = 1;
        int tempCount = 0;
        for(int time : times) {
            if(tempCount + time > mid) {
                tempLine++;
                tempCount = time;
            } else {
                tempCount += time;
            }
        }

        return tempLine <= m;
    }

    private static int binarySearch(int start, int end) {
        int answer = 0;
        while(start <= end) {
            int mid = (end - start) / 2 + start;

            if(isValid(mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}