import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static Set<String> set;
    static int[] combi;
    static StringBuilder answer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 중복 제거를 위한 set
        set = new HashSet<>();

        combi = new int[M];

        answer = new StringBuilder();

        backTracking(0, 0);

        System.out.print(answer);
    }

    private static void backTracking(int start, int index) {
        if(index == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(combi[i]).append(" ");
            }

            // 동일한 조합의 수열이 없을 때만 답에 저장
            if(!set.contains(sb.toString())) {
                answer.append(sb.toString()).append("\n");
                set.add(sb.toString());
            }

            return;
        }

        for (int i = start; i < N; i++) {
            combi[index] = arr[i];
            backTracking(i + 1, index + 1);
        }
    }
}