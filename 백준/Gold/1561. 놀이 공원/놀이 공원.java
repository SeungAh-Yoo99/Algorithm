import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 마지막 아이가 타는 시간을 기준으로 이분 탐색
        long s = 0, e = 2_000_000_000L * 30, m;
        long last = 0, total = 0;
        long sum, l;
        while(s <= e) {
            m = (s + e) / 2;

            sum = 0; l = 0;
            for (int i = 0; i < M; i++) {
                // m 시간 동안 태울 수 있는 아이 수
                sum += m / arr[i] + 1;

                // 마지막 아이가 탄 시간
                if(arr[i] * (m / arr[i]) > l) l = arr[i] * (m / arr[i]);
            }

            if(sum >= N) {
                last = l;
                total = sum; // 마지막 아이가 탄 시간까지 몇 명이나 태울 수 있는지 저장
                e = m - 1;
            }
            else {
                s = m + 1;
            }
        }

        // 마지막 아이가 탄 놀이기구 번호 구하기
        long sub = total - N; // 마지막 시간까지 태울 수 있는 총 인원 수와 태우고 싶은 아이 수의 차
        int result = 0;
        for (int i = M - 1; i >= 0; i--) { // 마지막 시간에 실제로 아이를 태우지 않은 놀이기구는 제외시키고, 실제로 아이를 태운 놀이기구 구하기
            if(last % arr[i] == 0) {
                if(sub == 0) {
                    result = i + 1;
                    break;
                }
                else sub--;
            }
        }

        System.out.println(result);
    }
}
