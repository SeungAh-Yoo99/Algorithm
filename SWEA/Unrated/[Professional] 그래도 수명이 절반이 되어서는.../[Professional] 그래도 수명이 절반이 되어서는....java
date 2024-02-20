import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // T := 테스트케이스의 개수
        int T = Integer.parseInt(br.readLine());

        int N, K, s, e, m, maxNum, left, right, sIdx, sCount, result; int[] W, sortW, S;
        for (int tc = 1; tc <= T; tc++) {
            // N := 블록 수, K := 덩어리 수
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 블록들의 wear level
            W = new int[N];

            // 이분탐색을 위한 wear level 정렬
            sortW = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                W[i] = Integer.parseInt(st.nextToken());
                sortW[i] = W[i];
            }

            // 정렬
            Arrays.sort(sortW);

            // 덩어리당 블록 수
            S = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            // 이분 탐색
            s = 0; e = N - 1;
            result = sortW[N - 1];
            while(s <= e) {
                m = (s + e) / 2;
                maxNum = sortW[m]; // wear level이 maxNum을 넘기지 않을 수 있는지 확인

                left = 0; right = 0; sIdx = 0;
                while(right < N) {

                    // maxNum 이하 값들만 있는 구간 확인
                    while(right < N && W[right] <= maxNum) right++;

                    // W[left] ~ W[right] 사이에 덩어리를 넣을 수 있는만큼 넣기
                    sCount = 0;
                    while(sIdx < K) {
                        if(sCount + S[sIdx] <= right - left) {
                            sCount += S[sIdx];
                            sIdx++;
                        }
                        else break;
                    }

                    // 덩어리들을 모두 넣은 경우
                    if(sIdx == K) break;

                    // 다음 구간 시작점 찾기
                    while(right < N && W[right] > maxNum) right++;
                    left = right;
                }

                // 덩어리들을 모두 넣을 수 있다면, 임시 저장 후 더 작은 경우도 확인
                if(sIdx == K) {
                    result = maxNum;
                    e = m - 1;
                }
                // 덩어리들을 모두 넣을 수 없다면, 더 큰 경우 확인
                else {
                    s = m + 1;
                }
            }

            // 답 저장
            answer.append("#" + tc + " " + result + "\n");
        }

        // 출력
        System.out.println(answer);
    }
}
