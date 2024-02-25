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

        // 작업별 작업 시간
        int[] time = new int[N + 1];

        // 선행 작업 개수
        int[] parent = new int[N + 1];

        // 자신을 선행 작업으로 가지고 있는 작업 리스트
        ArrayList<ArrayList<Integer>> child = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            child.add(new ArrayList<>());
        }

        int n, p;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());

            n = Integer.parseInt(st.nextToken());
            parent[i] = n;
            for (int j = 0; j < n; j++) {
                p = Integer.parseInt(st.nextToken());
                child.get(p).add(i);
            }
        }

        // 가장 늦게 끝나는 선행 작업 정보
        int[] maxTime = new int[N + 1];

        // 위상 정렬
        int result = 0;
        Queue<Integer> q = new LinkedList<>();

        // 처음부터 선행 작업이 없는 작업들을 큐에 담음
        for (int i = 1; i <= N; i++) {
            if(parent[i] == 0) {
                q.add(i);
                maxTime[i] = time[i];
            }
        }

        int now, next;
        while(!q.isEmpty()) {
            now = q.poll();
            result = Math.max(result, maxTime[now]);

            for (int i = 0; i < child.get(now).size(); i++) {
                next = child.get(now).get(i);
                parent[next]--;
                maxTime[next] = Math.max(maxTime[next], maxTime[now]);

                if(parent[next] == 0) {
                    q.add(next);
                    maxTime[next] += time[next];
                }
            }
        }

        System.out.println(result);
    }
}