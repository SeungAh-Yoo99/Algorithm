import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        // 최대 중량을 오름차순으로 정렬
        Arrays.sort(ropes);

        int result = 0;
        for(int i = 0; i < N; i++) {
            // 현재 로프를 최소 중량으로 했을 때, 최댓값이면 답 갱신
            result = Math.max(result, ropes[i] * (N - i));
        }

        System.out.println(result);
    }
}