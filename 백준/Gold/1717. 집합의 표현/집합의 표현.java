import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        StringBuilder result = new StringBuilder();

        int p, a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (p == 0) {
                union(a, b);
            } else {
                a = find(a);
                b = find(b);
                if(a == b) result.append("YES\n");
                else result.append("NO\n");
            }
        }

        System.out.print(result);
    }

    static private void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    static private int find(int num) {
        if(parent[num] == num) return num;

        return parent[num] = find(parent[num]);
    }
}
