import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long answer;

        if(W > S) {
            if(X > Y) answer = (Y * S) + ((X - Y) / 2 * S * 2) + ((X - Y) % 2 * W);
            else answer = (X * S) + ((Y - X) / 2 * S * 2) + ((Y - X) % 2 * W);
        }
        else if(W * 2 < S) answer = (X + Y) * W;
        else {
            if(X > Y) answer = Y * S + (X - Y) * W;
            else answer = X * S + (Y - X) * W;
        }

        System.out.println(answer);
    }
}