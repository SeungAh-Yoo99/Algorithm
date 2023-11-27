import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 현재 휴게소 개수, M := 더 지으려고 하는 휴게소의 개수, L := 고속도로의 길이
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int result = 0;
        if(N == 0) {
            result = L % (M + 1) == 0 ? L / (M + 1) : L / (M + 1) + 1;
            System.out.println(result);
        }
        else {
            // 현재 휴게소의 위치 입력
            st = new StringTokenizer(br.readLine());
            int[] rest = new int[N + 2];
            for (int i = 0; i < N; i++) {
                rest[i] = Integer.parseInt(st.nextToken());
            }
            rest[N] = 0; rest[N + 1] = L; // 고속도로 시작점과 끝점도 추가
            Arrays.sort(rest); // 휴게소 위치 순으로 오름차순 정렬

            // 휴게소가 없는 구간의 최댓값 구하기
            int maxDis = rest[1] - rest[0];
            for (int i = 2; i < N + 2; i++) {
                maxDis = Math.max(maxDis, rest[i] - rest[i - 1]);
            }

            // 이분 탐색으로 휴게소가 없는 구간의 최댓값을 임의로 지정
            // 임의로 지정한 최댓값이 가능한지 검사
            int s = 0, e = maxDis;
            int m = 0;
            while(s <= e) {
                m = ((s + e) / 2) + ((s + e) % 2);
                if(m == 0) break; // 휴게소 없는 구간이 0일순 없으므로 체크하지 않음

                int build = 0; // 두 휴게소 사이의 거리를 m 이하로 만들기 위해 지어야 하는 휴게소 개수
                int sub = 0; // 두 휴게소 사이 거리
                for (int i = 1; i < N + 2; i++) {
                    sub = rest[i] - rest[i - 1];

                    if(sub > m) {
                        int div = 2;
                        while((sub % div == 0 ? (sub / div) : (sub / div + 1)) > m) div++;
                        build += div - 1;
                    }
                }

                if(build <= M) {
                    result = m;
                    e = m - 1;
                } else{
                    s = m + 1;
                }
            }

            System.out.println(result);
        }
    }
}