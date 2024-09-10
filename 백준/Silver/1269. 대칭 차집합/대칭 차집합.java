import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer>  bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for (int b : bSet) { // A - B
            if(!aSet.contains(b)) count++;
        }
        for (int a : aSet) { // B - A
            if(!bSet.contains(a)) count++;
        }

        System.out.println(count);
    }
}