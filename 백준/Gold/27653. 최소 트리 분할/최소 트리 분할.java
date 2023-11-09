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

        // N := 정점의 개수
        int N = Integer.parseInt(br.readLine());

        // 가중치 입력
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 간선 정보 저장할 리스트
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        boolean[] visited = new boolean[N + 1]; // 노드 방문체크
        long result = arr[1]; // 답 저장
        Queue<Integer> q = new LinkedList<>(); // 탐색할 노드를 담을 큐
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) { // bfs
            int now = q.poll(); // 현재 노드
            int weigh = arr[now]; // 현재 노드의 가중치
            ArrayList<Integer> edge = edges.get(now); // 현재 노드의 간선 리스트

            for (int i = 0; i < edge.size(); i++) {
                int next = edge.get(i);
                if(visited[next]) continue;

                if(arr[now] < arr[next]) { // 현재 노드보다 연관된 노드의 가중치가 크다면
                    result += arr[next] - arr[now];
                }
                visited[next] = true;
                q.add(next);
            }
        }

        // 출력
        System.out.println(result);
    }
}