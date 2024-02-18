import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 사람 목록
        ArrayList<String> nameList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nameList.add(st.nextToken());
        }

        // 이름 사전 순으로 정렬
        Collections.sort(nameList);

        // 이름의 인덱스 정보
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < N; i++) {
            index.put(nameList.get(i), i);
        }

        // 가문의 시조인지 아닌지
        boolean[] isNotRoot = new boolean[N];

        // 주어진 조상 정보의 개수
        int[] parent = new int[N];

        // 주어진 자손 정보
        ArrayList<ArrayList<Integer>> children = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            children.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());

        String X, Y;
        int xIndex, yIndex;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            X = st.nextToken();
            Y = st.nextToken();

            xIndex = index.get(X);
            yIndex = index.get(Y);

            isNotRoot[xIndex] = true;
            parent[xIndex]++;
            children.get(yIndex).add(xIndex);
        }

        // 가문의 개수와 시조 이름 구하기
        int count = 0;
        StringBuilder root = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if(!isNotRoot[i]) {
                count++;
                root.append(nameList.get(i) + " ");
                q.add(i);
            }
        }
        answer.append(count + "\n" + root + "\n");

        // 각 사람들의 자녀 구하기
        ArrayList<ArrayList<Integer>> child = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            child.add(new ArrayList<>());
        }

        int now, next;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int i = 0; i < children.get(now).size(); i++) {
                next = children.get(now).get(i);
                parent[next]--;
                if(parent[next] == 0) {
                    child.get(now).add(next);
                    q.add(next);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer.append(nameList.get(i) + " ");
            answer.append(child.get(i).size());

            Collections.sort(child.get(i));
            for (int j = 0; j < child.get(i).size(); j++) {
                answer.append(" " + nameList.get(child.get(i).get(j)));
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}
