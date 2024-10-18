import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int A, B;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            edges.get(A).add(B);
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        // 다익스트라
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {X, 0});

        // 이미 방문한 적 있는 노드
        boolean[] visited = new boolean[N + 1];
        visited[X] = true;

        int[] now;
        ArrayList<Integer> edge;
        while(!q.isEmpty()) {
            now = q.poll();

            edge = edges.get(now[0]);
            for(int next : edge) {
                if(!visited[next]) {
                    visited[next] = true;
                    if(now[1] + 1 == K) {
                        resultList.add(next);
                    }
                    else {
                        q.offer(new int[] {next, now[1] + 1});
                    }
                }
            }
        }

        // 최단 거리가 K인 도시가 없다면
        if(resultList.isEmpty()) {
            System.out.println(-1);
            return;
        }

        // 정렬
        Collections.sort(resultList);
        StringBuilder result = new StringBuilder();
        for(int num : resultList) result.append(num).append("\n");
        System.out.print(result);
    }
}