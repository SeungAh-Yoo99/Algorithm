import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 배열의 크기, M := 최대 구간 개수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열
        int[] arr = new int[N];
        int min = 10_001, max = 0; // 배열의 최소값, 최대값 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        // 구간의 점수의 최대값을 기준으로 이분 탐색
        int s = 0, e = max - min, m, result = 0;
        while(s <= e) {
            m = (s + e) / 2; // 확인하고자 하는 최댓값의 최솟값 (모든 구간에서 구간의 점수가 m 이하여야 함)

            // M개 이하의 구간만 만들어서 m을 만들 수 있는지 확인
            int sum = 1; // 구간 개수
            int idx = 0;
            int tmpMin = 10_001, tmpMax  = 0; // 구간 최소, 최대
            while(idx < N) {
                tmpMin = Math.min(tmpMin, arr[idx]);
                tmpMax = Math.max(tmpMax, arr[idx]);

                // 현재 구간의 점수가 m 이하
                if(tmpMax - tmpMin <= m) idx++;
                // m을 초과하면 구간 나눠줌
                else {
                    sum++; // 구간 개수 + 1
                    if(sum > M) break; // 만들 수 있는 구간 개수를 넘었다면 다음 경우 확인하러 감
                    tmpMin = 10_001; // 다음 구간을 위해 구간 최소, 최대값 초기화
                    tmpMax = 0;
                }
            }

            if(sum <= M) { // 구간의 점수 최대값의 최솟값이 m을 넘지 않도록 구간을 나누었을 때, 구간의 개수가 M개 이하일 경우
                result = m;
                e = m - 1;
            } else { // m을 넘지 않도록 구간을 나누기 위해서 구간의 개수가 M개를 넘어야 한다면
                s = m + 1;
            }
        }

        // 츨력
        System.out.println(result);
    }
}