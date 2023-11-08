import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 카드의 수
        int N = Integer.parseInt(br.readLine());

        // 섞기 수열 입력
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[Integer.parseInt(st.nextToken())] = i; // 현재 자리에서 다음으로 갈 곳 저장
        }

        // 각 자리별로 원래 자리에 돌아오려면 최소 몇 번 루트를 돌아야 하는지 구하기
        boolean[] visited = new boolean[N + 1]; // 이미 구한 곳은 구하지 않음
        HashSet<Integer> set = new HashSet<>(); // 각 자리별 궤적을 저장하기 위한 set
        for (int i = 1; i <= N; i++) {
            if(visited[i]) continue;

            int now = arr[i]; // 한 번 섞었을 때의 위치
            int count = 1; // 최소 궤적 저장
            visited[now] = true;

            while(now != i) {
                count++;
                now = arr[now];
                visited[now] = true;
            }

            set.add(count); // 최소 궤적 저장
        }

        // set에 있는 최소 궤적들을 하나씩 꺼내며 최소공배수 구하기
        Iterator<Integer> iter = set.iterator();
        long result = 1;
        while(iter.hasNext()) {
            result = getLcm(result, (long)iter.next());
        }

        System.out.println(result);
    }

    private static int getLcm(long a, long b) {

        // 유클리드 호제법
        // 1. 최대공약수 구하기
        long gcd;
        if(a > b) gcd = getGcd(a, b);
        else gcd = getGcd(b, a);

        // 2. 최대공배수 구하기
        return (int)((a * b) / gcd);
    }

    private static long getGcd(long a, long b) {
        if(a % b == 0) return  b;
        return getGcd(b, a % b);
    }
}