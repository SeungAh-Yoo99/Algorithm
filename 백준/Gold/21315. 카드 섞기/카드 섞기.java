import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] card;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 카드 개수
        N = Integer.parseInt(br.readLine());

        // 2번의 섞기 후 카드 더미
        card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        // 가능한 모든 경우 구해보기
        Deque<Integer> dq1, dq2;
        LinkedList<Integer> list1, list2;
        int first = 0, second = 0;
for1:        for (int i = 1; Math.pow(2, i) < N; i++) {
            dq1 = new LinkedList<>();
            for (int k = 1; k <= N; k++) {
                dq1.add(k);
            }
            list1 = mix(i, dq1); // 첫 번째 섞기
            for (int j = 1; Math.pow(2, j) < N; j++) {
                dq2 = new LinkedList<>(list1);
                list2 = mix(j, dq2); // 두 번째 섞기

                // 입력 받은 순서와 같은지 확인
                if(isSame(list2)) {
                    first = i;
                    second = j;
                    break for1;
                }
            }
        }

        System.out.println(first + " " + second);
    }

    private static LinkedList<Integer> mix(int i, Deque<Integer> dq) {

        // 2^i개의 카드를 dq의 뒤에서 빼기
        Deque<Integer> tmp = new LinkedList<>();
        for (int j = 0; j < Math.pow(2, i); j++) {
            tmp.addFirst(dq.pollLast());
        }

        if(i == 0) { // 마지막 단계 섞기라면
            LinkedList<Integer> ret = new LinkedList<>(tmp);
            ret.addAll(dq);
            return ret;
        }

        // 다음 단계 카드 섞기
        LinkedList<Integer> list = mix(i - 1, tmp);

        // 남은 카드 넣어주기
        list.addAll(dq);

        return list;
    }

    private static boolean isSame(LinkedList<Integer> list) {

        for (int i = 0; i < N; i++) {
            if(card[i] != list.get(i)) return false;
        }

        return true;
    }
}