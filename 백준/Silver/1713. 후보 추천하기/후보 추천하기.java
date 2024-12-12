import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
* 학교 홈페이지에 추천 받은 학생의 사진을 게시할 수 있는 사진틀을 후보의 수 만큼 만들었다.
* 추천 받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
* 비어있는 사진틀이 없는 경우, 추천 수 가장 적은 애를 삭제하고 새롭게 추천 받은 애 올린다. 이때, 가장 적게
* 추천 받은 애가 2명 이상이면 가장 오래된 사진 삭제
* 현재 사진이 있는 애면 다른 학생의 추천을 받은 경우 추천 받은 횟수만 증가시킨다.
* 사진틀에 게시된 사진이 삭제되는 경우 해당 학생이 추천 받은 횟수는 0.
*
* 누가 최종 후보인지 결정하라
*
* */
public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, R;
    private static int[] recommends;
    private static HashMap<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        recommends = new int[R];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            recommends[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < R; i++) {
            int student = recommends[i];
            int[] temp = map.get(student);

            if(temp != null) { // 이미 있는 경우
                // 이미 추천받은 학생이라면 추천 횟수 증가
                temp[1]++;
             //   temp[0] = i;  // 가장 최근 추천 인덱스로 갱신
            } else { // 지금 추천 받은 곳에 없는 경우
                // 추천 받은 학생이 사진틀에 없으면
                if(map.size() == N) {
                    // 사진틀이 모두 차있으면 가장 추천 횟수가 적은 학생을 찾아 삭제
                    int minKey = -1;
                    int[] minValue = null;

                    for(Map.Entry<Integer, int[]> entry : map.entrySet()) {
                        int[] current = entry.getValue();
                        // 추천 횟수 적거나, 추천 횟수가 같으면 오래된 학생을 삭제
                        if(minValue == null || current[1] < minValue[1] ||
                                (current[1] == minValue[1] && current[0] < minValue[0])) {
                            minKey = entry.getKey();
                            minValue = current;
                        }
                    }

                    // 가장 추천 횟수가 적거나 오래된 학생 삭제
                    if(minKey != -1) {
                        map.remove(minKey);
                    }
                }

                // 새로운 학생 추가
                map.put(student, new int[]{i, 1});  // 새로운 학생은 추천 횟수 1
            }
        }

        // 결과 출력
        int[] result = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}