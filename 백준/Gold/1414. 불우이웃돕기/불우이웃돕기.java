import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int total = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        char[] length;
        int l = 0;
        for (int i = 1; i <= N; i++) {
            length = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if('a' <= length[j] && length[j] <= 'z') {
                    l = length[j] - 'a' + 1;
                }
                else if('A' <= length[j] && length[j] <= 'Z') {
                    l = length[j] - 'A' + 27;
                }
                else continue;

                total += l;
                pq.add(new int[] {i, j + 1, l});
            }
        }

        // 크루스칼 알고리즘
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int[] now;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if(union(now[0], now[1])) total -= now[2];
        }

        for (int i = 1; i <= N; i++) {
            if(find(i) != 1) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(total);
    }

    private static int find (int a) {
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