import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 행, M := 열
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 램프의 상태
        char[][] lamp = new char[N][M];
        for (int i = 0; i < N; i++) {
            lamp[i] = br.readLine().toCharArray();
        }

        // K := 스위치를 누를 횟수
        int K = Integer.parseInt(br.readLine());

        // K번의 스위치를 조작하여 i행을 킬 수 있을 때, 다른 몇 개의 행들을 킬 수 있는지 확인
        int answer = 0;
        boolean[] status; int num, canLight; boolean flag; // 변수들 선언
        for (int i = 0; i < N; i++) {
            status = new boolean[M]; // 열의 상태를 바꿨다면 true
            num = 0; // i행에서 켜야하는 전구 개수
            for (int j = 0; j < M; j++) { // i행의 열들 확인
                if(lamp[i][j] == '0') { // 켜야하는 전구
                    status[j] = true;
                    num++;
                }
            }

            // i행을 K번의 스위치 조작으로 킬 수 있는지 확인
            if((K - (num - 1)) % 2 == 1) { // 조작 가능
                canLight = 1;

                // 다른 행들 몇 개 켜졌는지 확인
                for (int j = 0; j < N; j++) {
                    if(j == i) continue; // i행은 넘어가줌

                    flag = true;
                    for (int k = 0; k < M; k++) { // j행의 열들 확인
                        if(lamp[j][k] == '1' && status[k]) { // 원래 켜져 있었는데, 스위치 조작으로 꺼진 겅우
                            flag = false;
                            break;
                        } else if(lamp[j][k] == '0' && !status[k]) { // 원래 꺼져 있었고, 스위치 조작으로 키지도 않은 경우
                            flag = false;
                            break;
                        }
                    }
                    if(flag) { // 위의 조건에 걸리지 않은 경우 j행은 켜져 있다.
                        canLight++;
                    }
                }

                // 더 많은 행을 킬 수 있는 경우로 답 저장
                answer = Math.max(answer, canLight);
            }
        }

        // 출력
        System.out.println(answer);
    }
}