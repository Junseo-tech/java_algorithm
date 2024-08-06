package august.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class what_is_recursion_func {
    private static String first = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    private static String second = "\"재귀함수가 뭔가요?\"";
    private static String third = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    private static String fourth = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    private static String fifth = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    private static String under = "____";
    private static String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    private static String finish = "라고 답변하였지.";
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sb.append(first).append("\n"); sb.append(second).append("\n"); sb.append(third).append("\n");
        sb.append(fourth).append("\n"); sb.append(fifth).append("\n");
        //sb.append(first).append("\n");
        recursion(1);
        sb.append(finish).append("\n");
        System.out.println(sb);

    }

    private static void recursion(int count){
        StringBuilder un = new StringBuilder();
        for (int i = 0; i < count; i++) {
            un.append(under);
        }
        if(count == N){
            sb.append(un).append(second).append("\n");
            sb.append(un).append(answer).append("\n");
            sb.append(un).append(finish).append("\n");
        } else {
            sb.append(un).append(second).append("\n");
            sb.append(un).append(third).append("\n");
            sb.append(un).append(fourth).append("\n");
            sb.append(un).append(fifth).append("\n");

            recursion(count + 1);
            sb.append(un).append(finish).append("\n");

        }

    }

}
