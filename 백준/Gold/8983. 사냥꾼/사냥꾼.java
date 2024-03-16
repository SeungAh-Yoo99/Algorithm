import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 사대 위치를 담아둘 트리셋
        TreeSet<Integer> ts = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ts.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        int x, y, left, right;
        Integer higher;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // 현재 동물을 잡을 수 있는 가장 왼쪽, 오른쪽 x 좌표
            left = Math.max(x - (L - y), 0) - 1;
            right = Math.min(x + (L - y), 1_000_000_000);

            // left와 right의 사이에 사대가 있다면 현재 동물을 잡을 수 있음
            higher = ts.higher(left);
            if(higher != null && higher <= right) result++;
        }

        System.out.println(result);
    }
}