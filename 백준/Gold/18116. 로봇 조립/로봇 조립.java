import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static int[] count;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 유니온 파인드
        parent = new int[1_000_001];
        for (int i = 2; i < 1_000_001; i++) {
            parent[i] = i;
        }

        // 부품 개수
        count = new int[1_000_001];
        Arrays.fill(count, 1);

        char c;
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            c = st.nextToken().toCharArray()[0];

            if(c == 'I') {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                // a와 b는 같은 로봇의 부품
                union(a, b);
            }
            else if(c == 'Q') {
                a = Integer.parseInt(st.nextToken());

                // robot(a)의 부품 개수
                a = find(a);
                result.append(count[a] + "\n");
            }
        }

        System.out.println(result);
    }

    private static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {

        a = find(a);
        b = find(b);

        if(a < b) {
            parent[b] = a;
            count[a] += count[b];
        }
        else if(a > b){
            parent[a] = b;
            count[b] += count[a];
        }
    }
}