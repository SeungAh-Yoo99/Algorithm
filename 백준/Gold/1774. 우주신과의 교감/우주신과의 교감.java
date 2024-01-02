import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 우주신들의 개수, M := 통로의 개수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 우주신들 좌표 정보
        int[][] map = new int[N + 1][2];

        //황선자와 우주신들의 좌표 입력
        int x, y;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        // 크루스칼 알고리즘을 사용하기 위한 부모 정보 배열
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 이미 연결된 곳 parent 배열에 연결해주기
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        // 크루스칼 알고리즘을 위해 모든 우주신 간 거리 구하기
        ArrayList<double[]> list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                list.add(new double[] {i, j, Math.sqrt(Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2))});
            }
        }

        // 간선 길이 오름차순 정렬
        Collections.sort(list, (o1, o2) -> o1[2] < o2[2] ? -1 : 1);

        double result = 0; // 간선을 새로 연결하는 경우, 간선 길이를 더해줌
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(Arrays.toString(list.get(i)));
            if(union((int)list.get(i)[0], (int)list.get(i)[1])) {
                //System.out.println(Arrays.toString(parent));
                result += list.get(i)[2];
                //System.out.println(result);
            }
            //System.out.println();
        }

        System.out.println(String.format("%.2f", result));
    }

    private static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return false; // 이미 연결 되어 있음

        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true; // 새로 연결함
    }
}