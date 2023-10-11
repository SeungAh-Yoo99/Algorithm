import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;

    static int[][] A;
    static int[][] map;
    static int[][] dead;

    static PriorityQueue<int[]> pq;

    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 땅의 크기, M := 나무 개수, K := 몇 년 후가 궁금한지
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // A[i][j] := (i, j)의 양분 정보
        A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 기존 맵 정보 (처음에는 모든 칸에 5만큼 양분이 있음)
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = 5;
            }
        }

        // dead[i][j] := 이번 봄에 죽은 나무 나이 합
        dead = new int[N + 1][N + 1];

        // A[x][y]에 있는 z살의 나무 정보
        pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]); // 나이가 어린 나무순으로 정렬
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 나이가 5의 배수인 나무를 담을 큐
        q = new LinkedList<>();

        // K년 진행
        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        // 살아있는 나무 개수 구하기
        int result = 0;
        while(!pq.isEmpty()) {
            pq.poll();
            result++;
        }

        System.out.println(result);
    }

    public static void spring() { // 봄
        // 성장한 나무 넣을 pq
        PriorityQueue<int[]> temp = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        // pq에서 나무를 하나씩 꺼내어 성장 후 temp에 넣기
        // 만약 나무가 죽는다면 dead에 넣기
        while(!pq.isEmpty()) {
            int[] tree = pq.poll();
            if(map[tree[0]][tree[1]] >= tree[2]) { // 성장 가능한 경우
                map[tree[0]][tree[1]] -= tree[2]++;
                temp.add(tree);

                // 나이가 5의 배수라면 q에 넣어줌
                if(tree[2] % 5 == 0) q.add(tree);
            } else { // 성장 불가능하여 죽는 경우
                dead[tree[0]][tree[1]] += tree[2] / 2;
            }
        }

        // 성장한 나무 리스트를 바꿔줌
        pq = temp;
    }

    public static void summer() { // 여름
        // 봄에 죽은 나무 양분으로 변환
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += dead[i][j];
                dead[i][j] = 0;
            }
        }
    }

    public static void fall() { // 가을
        // 나이가 5의 배수인 나무들은 번식을 함
        while(!q.isEmpty()) {
            int[] tree = q.poll();

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if(i == 0 && j == 0) continue; // 같은 자리 건너뜀
                    if(tree[0] + i >= 1 && tree[0] + i <= N && tree[1] + j >= 1 && tree[1] + j <= N) { // 범위 체크
                        pq.add(new int[] {tree[0] + i, tree[1] + j, 1});
                    }
                }
            }
        }
    }

    public static void winter() { // 겨울
        // A만큼 양분 추가
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += A[i][j];
            }
        }
    }
}