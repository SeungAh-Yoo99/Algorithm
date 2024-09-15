import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        if(T % 10 != 0) { // T초를 맞출 수 없는 경우
            System.out.println(-1);
            return;
        }

        StringBuilder result = new StringBuilder();

        // A 버튼
        result.append(T / 300).append(" ");
        T %= 300;

        // B 버튼
        result.append(T / 60).append(" ");
        T %= 60;

        // C 버튼
        result.append(T / 10);

        System.out.println(result);
    }
}