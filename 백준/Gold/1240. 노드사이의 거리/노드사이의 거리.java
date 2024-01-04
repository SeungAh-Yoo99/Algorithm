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

        // N := 노드의 개수, M := 거리를 알고 싶은 노드 쌍의 개수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 거리를 저장할 배열
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 트리 상에 연결된 두 점과 거리
        int a, b, c;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list.get(a).add(new int[] {b, c});
            list.get(b).add(new int[] {a, c});
        }

        // bfs로 거리 구하기
        StringBuilder result = new StringBuilder();
        int s, e; int[] now, next; boolean[] visited; Queue<int[]> q; ArrayList<int[]> link;
        for (int tc = 0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            q.add(new int[] {s, 0});

            visited = new boolean[N + 1];
            visited[s] = true;

bfs:        while(!q.isEmpty()) {
                now = q.poll();
                link = list.get(now[0]); // now 노드에 연결된 노드 리스트
                for (int i = 0; i < link.size(); i++) {
                    next = link.get(i); // 다음 노드 정보
                    if(!visited[next[0]]) { // 양방향 노드이기 때문에 이전 노드로 돌아가 무한 루프 도는 것을 방지

                        // 다음 노드가 찾으려고 하는 끝 노드라면
                        if(next[0] == e) {
                            result.append((now[1] + next[1]) + "\n"); // 답 저장 후
                            break bfs; // 다음 케이스로
                        }
                        visited[next[0]] = true; // 방문체크
                        q.add(new int[] {next[0], now[1] + next[1]});
                    }
                }
            }
        }

        // 출력
        System.out.println(result);
    }
}