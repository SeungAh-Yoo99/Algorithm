import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N; // N := 식재료의 개수
    static int[] minIgdt; // 최소 영양성분
    static int[][] igdt; // 식재료 정보

    static boolean[] visited; // 식재료 포함 여부
    static int resultPrice = -1; // 최소 가격
    static ArrayList<ArrayList<Integer>> resultList = new ArrayList<>(); // 최소 가격을 만족하는 재료 리스트들

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        N = Integer.parseInt(br.readLine());

        minIgdt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minIgdt[i] = Integer.parseInt(st.nextToken());
        }

        igdt = new int[N + 1][5];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                igdt[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N + 1];

        isInclude(1);


        // 출력
        if(resultPrice == -1) System.out.println(-1);
        else {
            // 정답 후보 정렬
            ArrayList<Integer> resultArray = getFirstArray();

            StringBuilder result = new StringBuilder();
            result.append(resultPrice + "\n");
            for (int i = 0; i < resultArray.size(); i++) {
                result.append(resultArray.get(i) + " ");
            }
            System.out.println(result);
        }
    }

    static void isInclude(int order) { // order번째 식재료를 포함할 것인지 결정
        if(order == N) {
            check();

            visited[order] = true;
            check();
            visited[order] = false;
            return;
        }

        // order번째 재료 포함하지 않는 경우
        isInclude(order + 1);

        // order번째 재료 포함하는 경우
        visited[order] = true;
        isInclude(order + 1);
        visited[order] = false;
    }

    static void check() { // 현재 재료로 최소 영양분을 만족하는지 확인

        int[] sumIgdt = new int[5];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(visited[i]) { // 포함하는 재료라면
                list.add(i);
                for (int j = 0; j < 5; j++) {
                    sumIgdt[j] += igdt[i][j]; // 최소 영양분 합을 구해줌
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if(sumIgdt[i] < minIgdt[i]) flag = false; // 최소 영양분을 만족시키지 못한 경우
        }

        if(flag) { // 최소 영양분을 만족시켰다면
            if(resultPrice == -1) { // 처음 만족시키는 경우라면
                resultPrice = sumIgdt[4];
                resultList.add(list);
            } else if (resultPrice == sumIgdt[4]) { // 현재 최소 가격과 동일할 경우
                resultList.add(list);
            } else if (resultPrice > sumIgdt[4]) { // 현재 리스트가 최소 가격일 경우
                resultPrice = sumIgdt[4];
                resultList.clear();
                resultList.add(list);
            }
        }
    }

    static ArrayList<Integer> getFirstArray() { // 최소 가격 재료 리스트 중 사전 순으로 첫번째 오는 것 반환
        ArrayList<Integer> ret = resultList.get(0);

        ArrayList<Integer> now;
        for (int i = 1; i < resultList.size(); i++) {
            now = resultList.get(i);
            boolean flag = false;
            int index = ret.size() > now.size() ? now.size() : ret.size(); // 더 짧은 리스트까지 비교
            for (int j = 0; j < index; j++) {
                if(ret.get(j) > now.get(j)) { // now가 사전 순 더 앞
                    flag = true;
                    ret = now;
                    break;
                } else if (ret.get(j) < now.get(j)) { // ret이 사전순 더 앞
                    flag = true;
                    break;
                }
            }
            // now가 더 짧은 배열이고 now와 ret의 앞부분이 같다면
            if(!flag && index == now.size()) ret = now;
        }

        return ret;
    }
}