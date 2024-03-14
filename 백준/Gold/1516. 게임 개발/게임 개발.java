import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 먼저 지어야 하는 건물 개수
        int[] parent = new int[N + 1];

        // 자신을 선행 건물로 가지고 있는 건물 리스트
        ArrayList<ArrayList<Integer>> pre = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            pre.add(new ArrayList<>());
        }

        // 건물 짓는데 걸리는 시간
        int[] time = new int[N + 1];

        // 현재 바로 지을 수 있는 건물 리스트
        Queue<Integer> q = new LinkedList<>();

        // 건물 정보 입력
        int b;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while ((b = Integer.parseInt(st.nextToken())) != -1) {
                parent[i]++;
                pre.get(b).add(i);
            }

            if(parent[i] == 0) q.add(i);
        }

        // 완성 시간
        long[] result = new long[N + 1];

        int now, next;
        while(!q.isEmpty()) {
            now = q.poll();

            result[now] += time[now];

            for (int i = 0; i < pre.get(now).size(); i++) {
                next = pre.get(now).get(i);
                parent[next]--;
                result[next] = Math.max(result[next], result[now]);
                if(parent[next] == 0) q.add(next);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            answer.append(result[i] + "\n");
        }
        System.out.print(answer);
    }
}