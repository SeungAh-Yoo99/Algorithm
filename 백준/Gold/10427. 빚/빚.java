import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] A;
    static long[] sumA;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // T := 테스트케이스의 수
        int T = Integer.parseInt(br.readLine());

        long result;
        for (int tc = 0; tc < T; tc++) {
            // N := 돈 빌린 횟수, A[i] := i번째에 빌린 돈 액수
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            A = new long[N];

            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(st.nextToken());
            }

            // A 올림차순으로 정렬
            Arrays.sort(A);

            // A의 누적합 구하기
            sumA = new long[N];
            sumA[0] = A[0];
            for (int i = 1; i < N; i++) {
                sumA[i] = sumA[i - 1] + A[i];
            }

            // S(i) 구하기
            result = 0;
            for (int i = 2; i <= N; i++) { // S(1)은 무조건 0이기 때문에 넘어감
                result += getS(i);
            }

            answer.append(result + "\n");
        }

        System.out.println(answer);
    }

    private static long getS(int i) { // S[i] 구해주는 함수

        /**
         *  A에서 i개를 골라야 함.
         *
         *  고른 i개 중 가장 큰 수(a)를 제외한 나머지 (i - 1)개의 수는
         *  A[a]보다 작은 수 중 가장 큰 것들로 골라야 함
         */

        long ret = Long.MAX_VALUE;

        long tmp;
        for (int j = i - 1; j < N; j++) {
            tmp = A[j] * i - (sumA[j] - (j - i > -1 ? sumA[j - i] : 0));
            ret = Math.min(ret, tmp);
        }

        return ret;
    }
}