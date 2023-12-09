import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // S, T 입력
        String S = br.readLine();
        String T = br.readLine();

        // T에서 S를 만들 수 있는지 확인
        int result = 0;

        Queue<String> q = new LinkedList<>();
        q.add(T);

        while(!q.isEmpty()) {

            // 문자열 하나 꺼내기
            String string = q.poll();

            if(string.equals(S)) {
                result = 1;
                break;
            }
            
            if(string.length() == 1) continue;

            // 마지막 문자가 A라면 A를 떼서 큐에 넣기
            char[] tmp = string.toCharArray();
            StringBuilder tmpSb = new StringBuilder(string);
            if(tmp[string.length() - 1] == 'A') {
                q.add(tmpSb.substring(0, string.length() - 1));
            }
            // 첫 문자가 B라면 뒤집고 B 떼서 큐에 넣기
            if(tmp[0] == 'B') {
                q.add(tmpSb.reverse().substring(0, string.length() - 1));
            }
        }

        System.out.println(result);
    }
}