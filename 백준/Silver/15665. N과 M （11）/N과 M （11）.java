import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer> list;
    static int[] arr;
    static StringBuilder answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 입력 받은 자연수 중복 제거
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 중복 제거한 자연수 리스트로 변환 후 정렬
        list = new ArrayList<>(set);
        Collections.sort(list);

        arr = new int[M];
        answer = new StringBuilder();

        // 백트래킹으로 조합 찾기
        backTracking(0);

        System.out.print(answer);
    }

    private static void backTracking(int idx) {

        if(idx == M) {
            for(int a : arr) answer.append(a).append(" ");
            answer.append("\n");
            return;
        }

        for(int i = 0; i < list.size(); i++) {
                arr[idx] = list.get(i);
                backTracking(idx + 1);
        }
    }
}