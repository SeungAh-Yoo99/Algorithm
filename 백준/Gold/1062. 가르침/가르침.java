import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int K;
    static int[] count;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] pick;
    static int result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // count[i] := i번째 단어가 몇 개의 글자로 이루어져 있는지 저장(i번째 단어를 읽기 위해 몇 개의 글자를 배워야 하는지)
        count = new int[N];

        // 글자가 어느 단어에 속해 있는지
        list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>());
        }

        char[] tmp;
        Set<Character> set;
        for (int i = 0; i < N; i++) {
            tmp = br.readLine().toCharArray();

            set = new HashSet<>();
            for (int j = 0; j < tmp.length; j++) {
                set.add(tmp[j]);
            }

            count[i] = set.size();
            for (char c : set) {
                list.get(c - 'a').add(i);
            }
        }

        // 모든 단어는 "anta"로 시작되고 "tica"로 끝나기 때문에 [a, n, t, i, c] 5개는 필수로 읽을 수 있어야 한다.
        if(K < 5) {
            System.out.println(0);
            return;
        }

        // 필수로 필요한 [a, n, t, i, c]는 조합에서 빼줌
        for (int i = 0; i < N; i++) {
            count[i] -= 5;
        }
        list.remove('t' - 'a');
        list.remove('n' - 'a');
        list.remove('i' - 'a');
        list.remove('c' - 'a');
        list.remove('a' - 'a');

        // [a, n, t, i, c]만으로 읽을 수 있는 단어 개수
        int base = 0;
        for (int i = 0; i < N; i++) {
            if(count[i] == 0) base++;
        }

        // K개 만큼 고른 글자
        pick = new boolean[21];

        // 읽을 수 있는 단어 개수의 최댓값
        result = 0;

        // 배울 글자 조합 구하기
        combi(0, 0);

        // 답 출력
        System.out.println(base + result);
    }

    private static void combi(int n, int no) {

        // 배울 K개의 글자를 모두 선택한 경우
        if(no == K - 5) {
            read();
            return;
        }

        if(n == 21) return;

        // n번째 글자를 선택하지 않은 경우
        combi(n + 1, no);
        // n번째 글자를 선택한 경우
        pick[n] = true;
        combi(n + 1, no + 1);
        pick[n] = false;
    }

    private static void read() { // 배운 단어 조합으로 몇 개의 단어를 읽을 수 있는지 확인하는 메소드

        int[] copy_count = count.clone();

        int can_read = 0; // 읽을 수 있는 단어 수

        for (int i = 0; i < 21; i++) {
            if(pick[i]) { // 배우기로 정한 글자라면
                for (int j = 0; j < list.get(i).size(); j++) { // 해당 글자를 포함하고 있는 단어에서 배워야 하는 글자 수를 빼줌
                    if(--copy_count[list.get(i).get(j)] == 0) { // 해당 단어가 포함하고 있는 글자를 모두 배웠다면
                        can_read++; // 읽을 수 있는 단어수 + 1
                    }
                }
            }
        }

        result = Math.max(result, can_read);
    }
}