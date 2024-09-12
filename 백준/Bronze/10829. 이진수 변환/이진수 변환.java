import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        StringBuilder result = new StringBuilder();
        while(N > 0) {
            result.append((N & 1) == 0 ? 0 : 1);
            N = N >> 1;
        }

        System.out.println(result.reverse());
    }
}