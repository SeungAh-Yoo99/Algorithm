import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        String input = br.readLine();
        StringTokenizer stInput = new StringTokenizer(input, ":");
        char[] charInput = input.toCharArray();

        // 그룹이 몇 개인지 계산
        int count = 0;
        while(stInput.hasMoreTokens()) {
            stInput.nextToken();
            count++;
        }

        // 답 구하기
        StringBuilder result = new StringBuilder();
        int idx = 0;
        int cnt = 0; // 현재 그룹의 원소 개수
        int group = 0; // 현재 몇 개의 그룹을 확인했는지
        while(idx < charInput.length) {
            if (charInput[idx] == ':') {
                if(idx == 0) idx++;
                if(charInput[idx - 1] == ':') { // "::" 인 경우
                    // (8 - 그룹 개수)만큼 0000이 옴
                    for (int i = 0; i < 8 - count; i++) {
                        group++;
                        if(group == 8) result.append("0000");
                        else result.append("0000:");
                    }
                    idx++;
                }
                else { // 하나의 그룹이 끝난 경우
                    group++;

                    for (int i = 0; i < 4 - cnt; i++) { // 생략된 "0" 추가
                        result.append("0");
                    }
                    for (int i = idx - cnt; i < idx; i++) { // 나머지 추가
                        result.append(charInput[i]);
                    }
                    result.append(":");
                    cnt = 0;
                    idx++;
                }
            } else { // ":"이나 마지막 원소가 나올 때까지 뒤로
                cnt++;

                if(idx == charInput.length - 1) { // 마지막 자릿수일 경우
                    for (int i = 0; i < 4 - cnt; i++) { // 생략된 "0" 추가
                        result.append("0");
                    }
                    for (int i = idx - cnt + 1; i <= idx; i++) { // 나머지 추가
                        result.append(charInput[i]);
                    }
                    cnt = 0;
                }

                idx++;
            }
        }

        // 출력
        System.out.println(result);
    }
}