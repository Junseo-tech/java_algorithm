package july.thirty.thirty_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class your_point {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        double multiplySum = 0.0;
        double totalSum = 0.0;
        double answer = 0.0;
        for(int i =0; i <20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double value = Double.parseDouble(st.nextToken());
            String score = st.nextToken();
            if(score.equals("P")){
                continue;
            }
            double scoreValue = map.get(score);
            totalSum += value * scoreValue;
            multiplySum += value;
        }
        answer = totalSum / multiplySum;
        System.out.println(answer);
    }
}
