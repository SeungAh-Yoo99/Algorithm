import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int P = Integer.parseInt(br.readLine());

        List<Integer> line;
        int count, size, index, s, e, m;
        for (int tc = 1; tc <= P; tc++) {

            line = new LinkedList<>(); // 줄

            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 테스트 케이스 번호 그냥 버리기
            line.add(Integer.parseInt(st.nextToken())); // 첫 학생 그냥 넣기

            count = 0; // 이번 테스트케이스에서 뒤로 물러서게 되는 횟수
            for (int i = 0; i < 19; i++) {
                size = Integer.parseInt(st.nextToken()); // 이번에 줄에 들어올 학생

                // 이분 탐색
                s = 0; e = line.size() - 1; index = line.size();
                while(s <= e) {
                    m = (s + e) / 2;

                    if(line.get(m) >= size) {
                        index = m;
                        e = m - 1;
                    } else s = m + 1;
                }

                count += line.size() - index; // index는 size보다 큰 키 중 가장 작은 키의 위치
                line.add(index, size);
            }

            result.append(tc).append(" ").append(count).append("\n");
        }

        System.out.print(result);
    }
}