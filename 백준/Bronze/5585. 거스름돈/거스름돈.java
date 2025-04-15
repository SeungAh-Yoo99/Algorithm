import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 1000 - Integer.parseInt(br.readLine());

        int[] change = {500, 100, 50, 10, 5, 1};

        int answer = 0;
        for (int i = 0; i < change.length; i++) {
            answer += n / change[i];
            n %= change[i];
        }

        System.out.println(answer);
    }
}
