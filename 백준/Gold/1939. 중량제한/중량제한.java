import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        final int MAX = 1_000_000_001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 섬의 개수, M := 다리의 개수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> edges = new ArrayList<>(); // 섬끼리 연결된 다리 정보
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int A, B, C;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            edges.get(A).add(new int[] {B, C});
            edges.get(B).add(new int[] {A, C});
        }

        // 출발, 도착 정보
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // BFS로 중량 최댓값 구하기
        int[] maximum = new int[N + 1]; // S에서 각 섬까지 최대 중량값
        maximum[S] = MAX;

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]); // 중량 최댓값이 큰 경우일수록 먼저 확인
        q.add(new int[] {S, MAX});

        int[] now, next;
        ArrayList<int[]> edge;
        while(!q.isEmpty()) {
            now = q.poll();

            if(now[1] < maximum[now[0]]) continue; // 이미 현재 방법보다 큰 경우를 확인한 경우, 이 방법은 생각해주지 않는다

            edge = edges.get(now[0]);

            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                if(maximum[next[0]] < Math.min(now[1], next[1])) { // 기존 방법으로 S -> next 를 가는 것보다 새로운 길로 S -> next를 가는게 더 나을 때만 이동
                    maximum[next[0]] = Math.min(now[1], next[1]);
                    q.add(new int[] {next[0], maximum[next[0]]});
                }
            }
        }

        // 출력
        System.out.println(maximum[E]);
    }
}
