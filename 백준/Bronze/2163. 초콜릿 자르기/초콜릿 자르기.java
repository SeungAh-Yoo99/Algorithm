import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초콜릿 쪼개기
        System.out.println(splitChoco(N, M));
    }

    private static int splitChoco(int w, int h) {

        // 이미 한 조각이라면
        if(w == 1 && h == 1) return 0;

        if(h > 1) { // 세로로 먼저 쪼개기

            if(h % 2 == 0) { // 세로가 짝수라면
                return 2 * splitChoco(w, h / 2) + 1;
            }
            else { // 홀수라면
                return splitChoco(w, h / 2) + splitChoco(w, h / 2 + 1) + 1;
            }
        }
        else { // 세로로 다 쪼갰다면 가로 쪼개기
            if(w % 2 == 0) { // 가로가 짝수라면
                return 2 * splitChoco(w / 2, 1) + 1;
            }
            else { // 홀수라면
                return splitChoco(w / 2, 1) + splitChoco(w / 2 + 1, 1) + 1;
            }
        }
    }
}