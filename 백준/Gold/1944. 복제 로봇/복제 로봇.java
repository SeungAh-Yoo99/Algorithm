import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[][] key;
    static boolean[][] visited;
    static PriorityQueue<int[]> pq;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        key = new int[M + 1][2];
        int count = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();

            // 시작 위치와 열쇠 위치 저장
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 'S' || map[i][j] == 'K') {
                    key[count][0] = i;
                    key[count++][1] = j;
                }
            }
        }

        // 시작 지점과 모든 키 사이의 거리 구하기
        pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        visited = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            getLength(i);
        }

        // 크루스칼로 알고리즘
        parent = new int[M + 1];
        for (int i = 0; i <= M; i++) {
            parent[i] = i;
        }

        int[] now;
        int result = 0;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if(union(now[0], now[1])) result += now[2];
        }

        for (int i = 0; i <= M; i++) {
            if(find(i) != 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(result);
    }

    private static void getLength(int start) { // bfs로 start에서 다른 열쇠까지의 거리 구하기

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        visited[key[start][0]][key[start][1]] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {key[start][0], key[start][1], 0});

        int[] now;
        int nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();

            if(map[now[0]][now[1]] == 'S' || map[now[0]][now[1]] == 'K') {
                for (int i = start + 1; i <= M; i++) {
                    if(key[i][0] == now[0] && key[i][1] == now[1]) {
                        pq.add(new int[] {start, i, now[2]});
                        break;
                    }
                }
            }

            for (int i = 0; i < 4; i++) { // 사방 탐색
                nx = now[0] + dx[i];
                ny = now[1] + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
                    if(!visited[nx][ny] && map[nx][ny] != '1') { // 아직 방문하지 않은 곳이며 벽이 아니라면
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny, now[2] + 1});
                    }
                }
            }
        }
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