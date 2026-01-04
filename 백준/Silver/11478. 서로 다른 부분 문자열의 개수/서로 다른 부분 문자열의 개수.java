import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        // 중복 없이 부분 문자열 담을 Set
        HashSet<String> set = new HashSet<>();

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 0; j <= S.length() - i; j++) {
                set.add(S.substring(j, j + i));
            }
        }

        System.out.println(set.size());
    }
}
