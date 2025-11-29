import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = (int)(((long)y * 100) / x);

        if(x == y) {
            System.out.println(-1);
            return;
        }

        // 이분탐색
        int s = 1, e = x, m;
        int answer = -1;
        while(s <= e) {
            m = (s + e) / 2;

            if(z < (int)(((long)(y + m) * 100) / (x + m))) {
                e = m - 1;
                answer = m;
            }
            else s = m + 1;
        }

        System.out.println(answer);

    }
}
