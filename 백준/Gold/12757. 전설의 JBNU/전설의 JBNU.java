import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int K;
    static TreeMap<Integer, Integer> db;
    static StringBuilder answer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        db = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            db.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        answer = new StringBuilder();

        int c, k, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());

            if(c == 1) {
                k = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                add(k, v);
            }
            else if(c == 2) {
                k = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                update(k, v);
            }
            else {
                k = Integer.parseInt(st.nextToken());
                get(k);
            }
        }

        System.out.print(answer);
    }

    private static void add(int key, int value) {
        db.put(key, value);
    }

    private static void update(int key, int value) {

        key = getKey(key);

        if(key == -1 || key == -2) return;

        db.put(key, value);
    }

    private static void get(int key) {

        key = getKey(key);

        if (key == -1) answer.append("-1\n");
        else if(key == -2) answer.append("?\n");
        else answer.append(db.get(key) + "\n");
    }

    private static int getKey(int k) {

        // 해당 Key가 있는 경우
        Integer ret = db.get(k);
        if(ret != null) return k;

        // 없는 경우 근접한 KEy 찾기
        Integer higher = db.higherKey(k);
        Integer lower = db.lowerKey(k);

        if(higher == null && lower == null) return -1;
        else if(higher == null) {
            if(k - lower > K) return -1;
            else return lower;
        }
        else if(lower == null) {
            if(higher - k > K) return -1;
            else return higher;
        }
        else {
            if(k - lower > K && higher - k > K) return -1;
            else if(k - lower > K) return higher;
            else if(higher - k > K)return lower;

            if(higher - k == k - lower) return -2;
            else if(higher - k < k - lower) return higher;
            else return lower;
        }
    }
}