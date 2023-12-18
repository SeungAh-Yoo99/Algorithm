import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 모기의 마릿수
        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N]; // 모기가 들어온 시간 저장 배열
        int[] output = new int[N]; // 모기가 나간 시간 저장 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = Integer.parseInt(st.nextToken());
            output[i] = Integer.parseInt(st.nextToken());
        }

        // 시간 순 정렬
        Arrays.sort(input);
        Arrays.sort(output);

        // 들어온 모기, 나간 모기 배열 인덱스
        int in = 0, out = 0;
        int count = 0, s = 0; // 현재 모기 마릿수, 현재 구간의 시작
        int result = 0, resultS = 0, resultE = 0; // 모기가 가장 많이 있는 시간대의 모기 마릿수, 시간대 시작, 종료
        while(in < N || out < N) {

            if(in == N) { // 모든 모기 입장 끝나고 퇴장만 남은 경우
                if(result < count) {
                    result = count;
                    resultS = s;
                    resultE = output[out];
                }
                count--;
                out++;
            } else if (input[in] < output[out]) { // 새로운 모기 입장
                count++;
                if(result < count) s = input[in];
                in++;
            } else if (input[in] > output[out]) { // 기존 모기 퇴장
                if(result < count) {
                    result = count;
                    resultS = s;
                    resultE = output[out];
                }
                count--;
                out++;
            } else if (input[in] == output[out]) { // 기존 모기 퇴장과 동시에 새로운 모기 입장
                in++;
                out++;
            }
        }

        System.out.println(result + "\n" + resultS + " " + resultE);
    }
}