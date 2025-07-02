import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<int[]>> edges;
    static int[][] edgesInfo;
    static long maxlen;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }

        edgesInfo = new int[N - 1][3];

        int from, to, cost;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            edges.get(from).add(new int[] {i, to, cost});
            edges.get(to).add(new int[] {i, from, cost});

            edgesInfo[i] = new int[] {from, to, cost};
        }

        /**
         * 간선을 하나씩 끊어본다.
         * 간선을 끊음으로써 생긴 두 개의 트리의 지름을 구하고,
         * 두 트리 지름을 합친다.
         */
        long answer = 0, tmp;
        for (int i = 0; i < N - 1; i++) {
            from = edgesInfo[i][0];
            to = edgesInfo[i][1];
            cost = edgesInfo[i][2];
            tmp = 0;

            maxlen = 0;
            getChildrenCosts(to, from, 0);
            tmp = maxlen;

            maxlen = 0;
            getChildrenCosts(from, to, 0);
            tmp += maxlen;

            answer = Math.max(answer, tmp + cost);
        }

        System.out.println(answer);
    }

    private static long getChildrenCosts (int parent, int node, int cost) {

        ArrayList<int[]> edge = edges.get(node);

        if(edge.size() == 1) { // 리프 노드인 경우
            return cost;
        }

        int[] next;
        List<Long> children = new ArrayList<>();
        for (int i = 0; i < edge.size(); i++) {
            next = edge.get(i);
            if(parent != next[1]) { // 역행 방지
                children.add(getChildrenCosts(node, next[1], next[2]));
            }
        }

        if(children.size() == 1) { // 자식이 하나라면 바로 리턴
            maxlen = Math.max(maxlen, children.get(0));
            return children.get(0) + cost;
        } else { // 아니라면 가장 긴 두 개의 자식으로 대소비교 후 리턴
            Collections.sort(children, Collections.reverseOrder());
            maxlen = Math.max(maxlen, children.get(0) + children.get(1));
            return children.get(0) + cost;
        }
    }
}
