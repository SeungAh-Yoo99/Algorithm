import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        int n, idx;
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            idx = 0;

            while(n > 0) {
                if((n & 1) == 1) result.append(idx).append(" ");
                n = n >> 1;
                idx++;
            }

            result.append("\n");
        }

        System.out.print(result);
    }
}