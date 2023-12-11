import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 노드의 개수, R := 루트 노드의 번호
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 노드 간선 정보
        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int a, b, d;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            edges.get(a).add(new int[] {b, d});
            edges.get(b).add(new int[] {a, d});
        }

        // 방문한 노드는 다시 방문하지 않기 위한 방문 체크 배열
        boolean[] visited = new boolean[N + 1];

        // 나무의 기둥 길이
        int height = 0;

        int now = R; // 루트 노드부터 시작
        ArrayList<int[]> edge;
        int count, nextNode;
        while(true) {

            visited[now] = true;

            edge = edges.get(now); // now에 연결된 간선 정보

            // now에서 연결된 간선 정보를 확인하여 기둥인지, 기가 노드인지 구하기
            count = 0;
            nextNode = 0;
            for (int i = 0; i < edge.size(); i++) {
                if(!visited[edge.get(i)[0]]) {
                    count++;
                    nextNode = i;
                }
            }

            if(count != 1) break; // now가 기가 노드면 더 이상 나무 기둥 길이 구하지 않음

            height += edge.get(nextNode)[1]; // 나무 기둥 길이 더해줌
            now = edge.get(nextNode)[0]; // 나무 기둥 위로 올라감
        }

        // dfs로 최장 가지 길이 구하기
        int maxLength = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {now, 0});

        while(!q.isEmpty()) {
            int[] node = q.poll();

            edge = edges.get(node[0]); // node의 간선 정보들 가져오기

            for (int i = 0; i < edge.size(); i++) {
                if(!visited[edge.get(i)[0]]) { // 아직 방문하지 않은 노드일 경우
                    visited[edge.get(i)[0]] = true;
                    q.add(new int[] {edge.get(i)[0], node[1] + edge.get(i)[1]});

                    maxLength = maxLength < node[1] + edge.get(i)[1] ? node[1] + edge.get(i)[1] : maxLength;
                }
            }
        }

        // 출력
        System.out.println(height + " " + maxLength);
    }
}