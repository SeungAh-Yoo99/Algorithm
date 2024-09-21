import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list,
                (o1, o2) -> o1.length() == o2.length() // 길이가 같으면
                            ? o1.compareTo(o2) // 사전순으로
                            : o1.length() - o2.length()); // 길이가 다르면 짧은 것 먼저

        StringBuilder result = new StringBuilder(list.get(0) + "\n");
        for (int i = 1; i < N; i++) {
            // 중복되지 않은 단어만 정답에 넣어줌
            if(!list.get(i).equals(list.get(i - 1))) result.append(list.get(i)).append("\n");
        }
        System.out.println(result);
    }
}