import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        int cost;
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                cost = Integer.parseInt(st.nextToken());
                if(j > i) pq.add(new int[] {i, j, cost});
            }
        }

        int[] now;
        int X = 0, K = 0;
        ArrayList<int[]> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            now = pq.poll();

            if(union(now[0], now[1])) {
                X += now[2];
                K++;
                list.add(new int[] {now[0], now[1]});
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(X +  " " + K + "\n");
        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i)[0] + " " + list.get(i)[1] + "\n");
        }
        System.out.print(answer);
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