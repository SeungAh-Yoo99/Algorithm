import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 아직 아무 점수도 없는 경우
        if(N == 0) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 새 점수가 링크 리스트에 올라갈 수 없는 경우
        if(N == P && arr[P - 1] >= num) {
            System.out.println(-1);
            return;
        }

        // 이분 탐색으로 num보다 작거나 같은 수 중 가장 큰 수의 위치 구하기
        int s = 0, e = N - 1, m;
        int result = N;
        while(s <= e) {
            m = (s + e) / 2;

            if(arr[m] <= num) {
                result = m;
                e = m - 1;
            }else s = m + 1;
        }
        result++; // 현재 result는 인덱스 값이므로 등수 값을 구하기 위해 +1

        System.out.println(result);
    }
}