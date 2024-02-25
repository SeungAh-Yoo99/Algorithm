import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1167 {

    static ArrayList<ArrayList<int[]>> edges;
    static boolean[] visited;
    static long result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());

        // 연결 노드 정보
        edges = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            edges.add(new ArrayList<>());
        }

        // 간선 정보 입력
        int s, e, w;
        for (int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            while(true) {
                e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                w = Integer.parseInt(st.nextToken());
                edges.get(s).add(new int[] {e, w});
            }
        }

        visited = new boolean[v + 1];
        result = 0;

        // 1번 노드부터 시작
        maxLength(1);

        System.out.println(result);
    }

    static private long maxLength(int node) {

        visited[node] = true;

        // node에 연결되어 있는 다른 노드 정보
        ArrayList<int[]> edge = edges.get(node);
        
        // node에 연결되어 있는 다른 노드 개수
        int size = edge.size();
        
        // node에 연결되어 있는 다른 노드들의 리프노드까지의 가장 긴 거리
        long[] weight = new long[size + 1];

        // 연결된 노드들로 이동
        int[] next;
        for (int i = 0; i < size; i++) {
            next = edge.get(i);

            if(!visited[next[0]]) {
                weight[i] = maxLength(next[0]) + next[1];
            }
        }

        // 정렬
        Arrays.sort(weight);

        // node에서 갈 수 있는 리프노드까지의 길이들 중, 가장 긴 길이 두 개 합을 최대값과 비교
        result = Math.max(result, weight[size] + weight[size - 1]);

        // node에서 갈 수 있는 리프노드까지의 길이들 중, 가장 긴 길이 리턴
        return weight[size];
    }
}
