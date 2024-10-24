import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Set<String> inCompany = new HashSet<>();

        String name, status;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            status = st.nextToken();

            if(status.equals("enter")) inCompany.add(name);
            else inCompany.remove(name);
        }

        // 역순 정렬
        List<String> list = new ArrayList<>(inCompany);
        Collections.sort(list, Collections.reverseOrder());

        // 출력
        StringBuilder result = new StringBuilder();
        for(String s : list) result.append(s).append("\n");
        System.out.print(result);
    }
}