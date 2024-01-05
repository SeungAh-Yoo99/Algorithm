import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 연병장의 크기, M := 조교의 수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 연병장 높이
        int[] height = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        // 시작 위치와 조절 높이
        ArrayList<int[]> start = new ArrayList<>();
        // 끝 위치와 조절 높이
        ArrayList<int[]> end = new ArrayList<>();

        int s, e, h;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            start.add(new int[] {s, h});
            end.add(new int[] {e, h});
        }

        // 명령 시작, 끝 리스트 위치 순으로 정렬
        Collections.sort(start, (o1, o2) -> o1[0] - o2[0]);
        Collections.sort(end, (o1, o2) -> o1[0] - o2[0]);

        // 1~N까지 한 칸 씩 이동하며 명령이 새로 시작되면 명령 조절 높이 반영, 명령이 끝나면 조절 높이 빼주기
        int sIdx = 0, eIdx = 0, k = 0;
        for (int i = 1; i <= N; i++) {
            while(sIdx < M && start.get(sIdx)[0] == i) k += start.get(sIdx++)[1]; // 시작해줘야 할 명령이 있다면 반영

            height[i] += k;

            while(eIdx < M && end.get(eIdx)[0] == i) k -= end.get(eIdx++)[1]; // 끝내야할 명령이 있다면 반영
        }

        // 출력
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            result.append(height[i] + " ");
        }
        System.out.println(result);
    }
}