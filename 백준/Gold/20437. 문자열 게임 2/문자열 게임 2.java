import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 문자열 게임의 수 T 입력
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            // 문자열 W 입력
            char[] W = br.readLine().toCharArray();
            // 정수 K 입력
            int K = Integer.parseInt(br.readLine());

            // 문자의 개수를 담을 map
            HashMap<Character, Integer> map = new HashMap<>();

            /**
             * 3번의 문자열 구하기
             * 투 포인터(s, e)로 문자의 개수 세기
             * e를 한 칸씩 뒤로 옮기며 문자 개수 +1
             * 어느 한 문자(c)를 K개만큼 찾았다면 (e - s + 1)를 저장해둠
             * 가장 앞에 있는 c를 찾을 때까지 s를 한 칸씩 뒤로 옮기며 거친 문자들의 개수를 -1
             * 다시 e를 한칸 씩 뒤로 옮기며 위의 과정을 반복
             */
            int s = 0, e = 0;

            int result3 = 0;
            while(e < W.length) {

                char c = W[e];

                // 마지막 문자열 개수 추가
                map.put(c, map.getOrDefault(c, 0) + 1);

                // 개수 확인
                int num = map.get(c);

                if(num == K) { // K개만큼 찾았다면
                    while(s < e) {
                        map.put(W[s], map.get(W[s]) - 1);
                        if(W[s] == c) break;
                        else s++;
                    }

                    int sub = e - s + 1;
                    result3 = result3 == 0 ? sub : result3 > sub ? sub : result3;
                    s++;
                }
                e++;
            }

            // 큐를 사용하여 4번의 문자열 구하기
            int result4 = 0;
            ArrayList<Queue<Integer>> qArr = new ArrayList<>();
            for (int i = 0; i < 'z' - 'a' + 1; i++) { // 알파벳 소문자 종류의 개수만큼 큐 생성
                qArr.add(new LinkedList<>());
            }

            for (int i = 0; i < W.length; i++) {
                char c = W[i]; // 현재 문자

                Queue<Integer> q = qArr.get(c - 'a'); // 현재 문자를 담는 큐 가져오기
                q.add(i); // 문자가 몇 번째 인덱스에 나오는지 담기

                if(q.size() == K) { // 현재 문자가 K개만큼 담겼다면
                    int tmp = q.poll(); // K개에 해당하는 문자 중 가장 앞에 있는 문자의 인덱스를 꺼냄
                    result4 = result4 < (i - tmp + 1) ? (i - tmp + 1) : result4;
                }
            }

            if(result3 == 0) result.append(-1 + "\n");
            else result.append(result3 + " " + result4 + "\n");
        }

        System.out.println(result);
    }
}