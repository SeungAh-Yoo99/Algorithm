import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 유니온 파인드에 쓰일 부모 배열
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int u, v;
        int result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            // 이미 연결되어 있는 경우 필요없는 연결 -> 연결을 끊어준다
            if(!union(u, v)) result++;
        }

        // 아직 연결되지 않은 뉴런이 있는 경우 새로 연결해준다
        for (int i = 2; i <= N; i++) {
            if (find(i) != 1) {
                parent[i] = 1;
                result++;
            }
        }

        // 답 출력
        System.out.println(result);
    }

    private static int find(int a) {
        if(a == parent[a]) return a;

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
