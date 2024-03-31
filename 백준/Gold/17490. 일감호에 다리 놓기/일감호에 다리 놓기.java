import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());


        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pq.add(new int[] {0, i, Integer.parseInt(st.nextToken())});
        }

        for (int i = 1; i < N; i++) {
            pq.add(new int[] {i, i + 1, 0});
        }
        pq.add(new int[] {N, 1, 0});

        boolean[] construction = new boolean[N + 1];
        int[] ij = new int[2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ij[0] = Integer.parseInt(st.nextToken());
            ij[1] = Integer.parseInt(st.nextToken());
            Arrays.sort(ij);

            if(ij[0] == 1 && ij[1] == N) construction[N] = true;
            else construction[ij[0]] = true;
        }

        // 공사하는 지점이 한 부분이라면 모든 강의실 간의 이동 가능
        if(M < 2) {
            System.out.println("YES");
            return;
        }
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int[] now;
        long cost = 0;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if(now[2] == 0 && construction[now[0]]) continue;

            if(union(now[0], now[1])) cost += now[2];
        }

        if(cost <= K) System.out.println("YES");
        else System.out.println("NO");
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