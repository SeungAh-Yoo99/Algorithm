import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};

    static class Maze implements Comparable<Maze>{

        int x, y;
        int count;

        Maze(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Maze m) {
            return count - m.count;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 방문 체크
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], N + M + 1);
        }

        // bfs
        PriorityQueue<Maze> pq = new PriorityQueue<>();
        pq.add(new Maze(0, 0, 0));

        Maze now;
        int nx, ny;
        int result = 0;
        while(!pq.isEmpty()) {
            now = pq.poll();

            // 도착
            if(now.x == N - 1 && now.y == M - 1) {
                result = now.count;
                break;
            }

            // 이미 더 나은 루트를 찾았다면 다음 루트 확인하러
            if(now.count > visited[now.x][now.y]) continue;

            for (int i = 0; i < 4; i++) { // 사방 탐색
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위 체크
                    if(map[nx][ny] == '0' && visited[nx][ny] > now.count) { // 빈 방, 더 나은 루트 찾았을 때만 이동
                        visited[nx][ny] = now.count;
                        pq.add(new Maze(nx, ny, now.count));
                    }
                    else if(map[nx][ny] == '1' && visited[nx][ny] > now.count + 1) { // 벽, 더 나은 루트 찾았을 때만 이동
                        visited[nx][ny] = now.count + 1;
                        pq.add(new Maze(nx, ny, now.count + 1));
                    }
                }
            }
        }

        System.out.println(result);
    }
}