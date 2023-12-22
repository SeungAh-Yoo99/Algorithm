import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] child;

    static int[] under;
    static boolean[] visited;

    static ArrayList<ArrayList<Integer>> map;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 노드의 개수
        N = Integer.parseInt(br.readLine());

        // 노드의 자식 정보
        child = new int[N + 1][2];
        int n, l, r;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            child[n][0] = l; // 왼쪽 자식
            child[n][1] = r; // 오른쪽 자식
        }

        // 트리의 최대 높이 구하기
        under = new int[N + 1]; // 현재 노드를 루트 노드로 하는 부분 트리의 레벨
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) partLevel(i); // i를 루트 노드로 하는 부분 트리 레벨 구하기
        }

        // 가장 큰 레벨을 가지고 있는 노드가 루트 노드
        int root = -1, level = -1;
        for (int i = 1; i <= N; i++) {
            if(level < under[i]) {
                root = i;
                level = under[i];
            }
        }
        level++; // 레벨이 1부터 시작하므로 + 1

        // 각 노드의 레벨에 자신의 열 넣기
        map = new ArrayList<>();
        for (int i = 0; i <= level; i++) {
            map.add(new ArrayList<>());
        }
        getLevel(root, 1, 0);

        // 각 레벨 별 왼쪽 끝과 오른쪽 끝의 차 구하기
        int resultLevel = 0, resultWidth = 0, sub;
        ArrayList<Integer> tmp;
        for (int i = 1; i <= level; i++) {
            tmp = map.get(i);
            sub = tmp.get(tmp.size() - 1) - tmp.get(0) + 1;
            if(resultWidth < sub) {
                resultLevel = i;
                resultWidth = sub;
            }
        }

        // 출력
        System.out.println(resultLevel + " " + resultWidth);
    }

    private static int partLevel(int node) { // node를 루트 노드로 하는 부분 트리의 레벨 리턴

        visited[node] = true;

        // 리프 노드일 경우 0 반환
        if(child[node][0] == -1 && child[node][1] == -1) return 0;

        int left, right;
        if(child[node][0] != -1) { // 왼쪽 자식이 있는 경우
            left = child[node][0];
            if(visited[left]) under[node] = under[left] + 1; // 왼쪽 자식의 부분 레벨을 이미 구한 경우
            else under[node] = partLevel(left) + 1; // 아직 안구한 경우 구하고 옴
        }
        if(child[node][1] != -1) { // 오른쪽 자식이 있는 경우
            right = child[node][1];
            if(visited[right]) under[node] = Math.max(under[node], under[right] + 1); // 왼쪽 자식의 부분 레벨과 비교하여 저장
            else under[node] = Math.max(under[node], partLevel(right) + 1);
        }

        return under[node];
    }

    private static int getLevel(int node, int level, int y) {

        // 리프 노드라면
        if(child[node][0] == -1 && child[node][1] == -1) {
            map.get(level).add(y + 1);
            return y + 1;
        }

        int ret = 0;
        if(child[node][0] != -1) { // 왼쪽 자식이 있다면
            ret = getLevel(child[node][0], level + 1, y) + 1;
        } else { // 왼쪽 자식 없다면
            ret = y + 1;
        }
        map.get(level).add(ret);
        // 오른쪽 자식이 있다면
        if(child[node][1] != -1) {
            ret = getLevel(child[node][1], level + 1, ret);
        }

        return ret;
    }
}