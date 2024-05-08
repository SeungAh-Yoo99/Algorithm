import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] edges = new char[N][N];
        for (int i = 0; i < N; i++) {
            edges[i] = br.readLine().toCharArray();
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(edges[i][j] == 'Y') {
                    q.add(new int[] {i, j});
                }
            }
        }

        // 도로의 수가 부족한 경우
        if(q.size() < M) {
            System.out.println(-1);
            return;
        }

        // 유니온 파인드
        parent = new int[N];
        for (int i = 1; i < N; i++) {
            parent[i] = i;
        }

        // 집합이 연결되는데에 최소로 필요한 도로로 사용되지 않은 도로
        Queue<int[]> rest = new LinkedList<>();

        int count = 0; // 집합에 포함된 도로 개수
        int[] result = new int[N]; // result[i] := i를 끝점으로 갖는 도로의 개수

        int[] now;
        while(!q.isEmpty()) {
            now = q.poll();

            if(union(now[0], now[1])) {
                count++;
                result[now[0]]++;
                result[now[1]]++;
            }
            else {
                rest.add(now);
            }
        }

        // 집합이 연결되지 않은 경우
        if(count < N - 1) {
            System.out.println(-1);
            return;
        }

        // 모자란 도로의 개수 채우기
        while(count++ < M) {
            now = rest.poll();

            result[now[0]]++;
            result[now[1]]++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer.append(result[i] + " ");
        }
        System.out.println(answer);
    }

    private static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {

        a = find(a);
        b = find(b);

        if(a == b) return false;

        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }
}