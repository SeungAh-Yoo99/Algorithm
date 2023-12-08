import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 집의 개수, C := 공유기 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 집의 좌표
        int[] home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        // 집 좌표 정렬
        Arrays.sort(home);

        // 이분 탐색 가능한 공유기 좌표 구하기
        int result = 0;
        int s = 1, e = home[N - 1] - home[0];
        int m, last, count;
        while(s <= e) {
            m = (s + e) / 2;

            // 마지막으로 공유기 설치한 집
            last = 0; // 0번 집에는 무조건 공유기 설치
            // m보다 먼 거리에 설치할 수 있는 공유기 수
            count = 1;
            for (int i = 1; i < N; i++) {
                if(home[i] - home[last] >= m) {
                    count++;
                    last = i;
                }
                if(count == C) break;
            }

            if(count == C) { // m 이상의 거리를 두고 C개 이상의 공유기를 설치할 수 있는 경우
                result = m;
                s = m + 1;
            }
            else { // m 이상의 거리를 두고 공유기를 설치할 수 없는 경우
                e = m - 1;
            }
        }

        System.out.println(result);
    }
}