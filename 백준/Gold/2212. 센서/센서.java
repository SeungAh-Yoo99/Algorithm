import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 센서 간 거리
        int[] len = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            len[i] = arr[i + 1] - arr[i];
        }

        // 정렬
        Arrays.sort(len);

        int answer = 0;

        // 센서 간 거리가 가까운 것부터 하나의 집중국이 처리할 수 있도록 합치기
        // 집중국을 K개만 설치할 수 있으므로 N - K개만큼 합치기
        for (int i = 0; i < N - K; i++) {
            answer += len[i];
        }

        System.out.println(answer);
    }
}
