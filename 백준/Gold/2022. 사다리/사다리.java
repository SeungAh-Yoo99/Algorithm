import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double s = 0, e = Math.min(x, y), m;
        double h1, h2, res;
        while(e - s >= 0.001) {
            m = (s + e) / 2;

            h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(m, 2));
            h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(m, 2));
            res = (h1 * h2) / (h1 + h2);

            // res가 높게 나왔다면 가로폭을 더 크게 해주어야 res가 작아짐
            if(res >= c) s = m;
            // res가 낮게 나왔다면 가로폭을 더 작게 해주어야 res가 커짐
            else e = m;
        }

        System.out.println(String.format("%.3f", e));
    }
}