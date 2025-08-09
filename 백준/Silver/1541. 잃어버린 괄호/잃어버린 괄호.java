import java.io.*;

public class Main {
    private static String[] expression;
    private static int num;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        num = 0;

        expression = input.split("-");

        String[] first = expression[0].split("\\+");
        for(int i = 0; i < first.length; i++) {
            num += Integer.parseInt(first[i]);
        }

        calculate();
        System.out.println(num);

    }

    private static void calculate() {
        for(int i = 1; i < expression.length; i++) {
            String[] temp = expression[i].split("\\+");
            int tempNum = 0;
            for(int j = 0; j < temp.length; j++) {
                tempNum += Integer.parseInt(temp[j]);
            }
            num -= tempNum;
        }
    }
}
