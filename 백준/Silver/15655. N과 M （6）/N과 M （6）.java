import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M;
    static List<Integer> list;
    static StringBuilder result;
    static int[] arr;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 중복을 제거하기 위한 set
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 중복을 제거한 수열을 담은 list
        list = new ArrayList<>(set);

        // 정렬
        Collections.sort(list);

        // 수열 구하기
        result = new StringBuilder();
        arr = new int[M];
        combi(0, 0 );

        // 출력
        System.out.print(result);
    }

    private static void combi(int n, int s) {

        if(n == M) {
            for(int i : arr) {
                result.append(i).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = s; i < list.size(); i++) {
            arr[n] = list.get(i);
            combi(n + 1, i + 1);
        }
    }
}