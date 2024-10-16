import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isSheep;
    static int[] count;
    static ArrayList<ArrayList<Integer>> edges;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        isSheep = new boolean[N + 1];  // 양인지 늑대인지 여부

        count = new int[N + 1]; // 개체수

        edges = new ArrayList<>(); // 인덱스 섬에 들어오는 다리 리스트
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            // 양인 경우
            if(st.nextToken().equals("S")) isSheep[i] = true;

            // 개체수 저장
            count[i] = Integer.parseInt(st.nextToken());

            // 다리 정보 저장
            edges.get(Integer.parseInt(st.nextToken())).add(i);
        }

        System.out.println(dfs(1));
    }

    private static long dfs(int node) {

        long ret = 0; // 리프 노드 섬에서부터 현재 섬까지 살아나온 양의 수

        ArrayList<Integer> edge = edges.get(node);
        for (int i = 0; i < edge.size(); i++) { // 자식 노드 섬들에서 살아나온 양의 수를 함친다
            ret += dfs(edge.get(i));
        }

        // 현재 섬에도 양이 살고 있다면, 더해서 부모 섬으로 보냄
        if(isSheep[node]) return ret + count[node];
        // 현재 섬에 늑대가 살고 있다면, 늑대 수만큼 빼서 보냄
        else return ret - count[node] < 0 ? 0 : ret - count[node];
    }
}