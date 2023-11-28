import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N; // 문자열의 개수
    static char[][] arr; // 문자열 배열

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 문자열의 개수
        N = Integer.parseInt(br.readLine());

        // 문자열 배열
        arr = new char[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 정렬
        quickSort(0, N - 1);

        // 출력
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result.append(arr[i][j]);
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    private static void quickSort(int left, int right) { // 퀵 소트

        if(left >= right) return;

        int pivot = sort(left, right);

        quickSort(left, pivot - 1);
        quickSort(pivot + 1, right);
    }

    private static int sort(int left, int right) { // pivot을 중심으로 pivot보다 사전순 앞이면 왼쪽, 뒤면 오른쪽으로 정렬

        char[] pivot = arr[left];
        int i = left, j = right;

        while(i < j) {
            while(compare(pivot, arr[j]) == -1) j--;
            while(i < j && compare(pivot, arr[i]) == 1) i++;
            swap(i, j);
        }
        swap(left, i);

        return i;
    }

    private static int compare(char[] str1, char[] str2) { // str1이 사전순 앞이라면 -1, str2가 사전순 앞이거나 같다면 1 반환

        int length = Math.min(str1.length, str2.length); // 더 짧은 배열 길이까지만 체크

        for (int i = 0; i < length; i++) {
            int p1 = 0, p2 = 0; // str1, str2의 문자 우선순위1

            // 대문자일 경우 우선순위
            if(str1[i] >= 'A' && str1[i] <= 'Z') p1 = (str1[i] - 'A') * 2 + 1;
            // 소문자일 경우 우선순위
            else if(str1[i] >= 'a' && str1[i] <= 'z') p1 = (str1[i] - 'a') * 2 + 2;

            // 대문자일 경우 우선순위
            if(str2[i] >= 'A' && str2[i] <= 'Z') p2 = (str2[i] - 'A') * 2 + 1;
            // 소문자일 경우 우선순위
            else if(str2[i] >= 'a' && str2[i] <= 'z') p2 = (str2[i] - 'a') * 2 + 2;

            // str1가 우선순위가 더 높을 경우
            if(p1 < p2) return -1;
            // str2가 우선순위가 더 높을 경우
            else if (p1 > p2) return 1;
            // 둘의 우선순위가 같을 경우
            else {
                if(p1 == 0) { // 둘 다 숫자가 왔을 경우

                    // 연속으로 오는 수들 값 비교
                    int e1 = i, e2 = i;
                    ArrayList<Integer> num1 = new ArrayList<>(), num2 = new ArrayList<>();

                    // 앞의 0 개수 세기
                    int zero1 = 0, zero2 = 0;
                    boolean flag1 = false, flag2 = false;

                    while(e1 < str1.length && str1[e1] >= '0' && str1[e1] <= '9') {
                        if(str1[e1] != '0') flag1 = true; // 앞자리가 0이 아니면 flag1에 표시
                        if(!flag1) zero1++;
                        else num1.add(str1[e1] - '0');
                        e1++;
                    }
                    while(e2 < str2.length && str2[e2] >= '0' && str2[e2] <= '9') {
                        if(str2[e2] != '0') flag2 = true; // 앞자리가 0이 아니면 flag2에 표시
                        if(!flag2) zero2++;
                        else num2.add(str2[e2] - '0');
                        e2++;
                    }

                    // 두 수 비교
                    if(num1.size() < num2.size()) return -1;
                    else if (num1.size() > num2.size()) return 1;
                    else { // 값이 자릿수가 같을 경우, 한자리씩 비교
                        for (int j = 0; j < num1.size(); j++) {
                            if(num1.get(j) < num2.get(j)) return -1;
                            else if(num1.get(j) > num2.get(j)) return 1;
                        }
                        // 여기까지 왔다면 값이 같다는 것.
                        // 앞에 온 0의 개수를 비교해준다.
                        if(zero1 < zero2) return -1;
                        else if(zero1 > zero2) return 1;
                        else { // 0의 개수까지 같을 경우 다음 자리를 확인하러 감
                            i = e1 - 1;
                        }
                    }
                }
            }
        }

        // 여기까지 메소드를 빠져나가지 못한 경우 length까지는 같은 문자열.
        // 더 짧은 문자가 사전순 앞으로 옮
        if(str1.length < str2.length) return -1;
        else return 1;
    }

    private static void swap(int i, int j) {
        char[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}