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
        StringBuilder answer = new StringBuilder();

        int n, m, s, e, result; ArrayList<ArrayList<int[]>> edges; boolean[] nodeVisited, edgeVisited;
        int tc = 1;
        while(true) {
            // n := 정점의 개수, m := 간선의 개수
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 테스트 케이스 끝
            if(n == 0 && m == 0) break;

            // 간선 정보 입력
            edges = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                edges.get(s).add(new int[] {e, i}); // 몇 번째 간선인지도 저장
                edges.get(e).add(new int[] {s, i});
            }

            // dfs로 트리 개수 구하기
            result = 0;
            nodeVisited = new boolean[n + 1];
            edgeVisited = new boolean[m];
            for (int i = 1; i <= n; i++) {
                if(!nodeVisited[i]) { // 아직 트리 검사하지 않은 노드라면 dfs로 트리 유효성 검사
                    if(dfs(i, edges, nodeVisited, edgeVisited)) result++; // 트리라면 개수 세줌
                }
            }

            // 답 저장
            if(result > 1) answer.append("Case " + tc + ": A forest of " + result + " trees.\n");
            else if(result == 1) answer.append("Case " + tc + ": There is one tree.\n");
            else answer.append("Case " + tc + ": No trees.\n");
            tc++;
        }

        // 답 출력
        System.out.println(answer);
    }

    private static boolean dfs(int i, ArrayList<ArrayList<int[]>> edges, boolean[] nodeVisited, boolean[] edgeVisited) {

        // i부터 dfs 시작
        nodeVisited[i] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        int n = 1, e = 0; // 노드 개수, 간선 개수

        int now; int[] next; ArrayList<int[]> edge;
        while(!q.isEmpty()) {
            now = q.poll();
            edge = edges.get(now);
            for (int j = 0; j < edge.size(); j++) {
                next = edge.get(j);

                if(!edgeVisited[next[1]]) { // 아직 사용한 적 없는 간선이라면
                    edgeVisited[next[1]] = true;
                    e++;
                    if(!nodeVisited[next[0]]) { // 처음 방문하는 노드라면
                        nodeVisited[next[0]] = true;
                        n++;
                        q.add(next[0]);
                    }
                }
            }
        }

        // 간선 개수가 노드 개수 - 1이라면 트리
        if(n == e + 1) return true;
        else return false;
    }
}