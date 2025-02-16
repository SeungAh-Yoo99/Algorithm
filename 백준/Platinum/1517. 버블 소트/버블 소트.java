import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long answer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        mergeSort(A);
        System.out.println(answer);
    }

    private static int[] mergeSort(int[] arr) {

        if(arr.length == 1) return arr;

        int mid =  arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        int[] ret = new int[arr.length];
        int idx = 0, idxL = 0, idxR = 0;
        while(idxL < left.length && idxR < right.length) {
            if(left[idxL] <= right[idxR]) ret[idx++] = left[idxL++];
            else {
                answer += left.length - idxL;
                ret[idx++] = right[idxR++];
            }
        }
        while(idxL < left.length) ret[idx++] = left[idxL++];
        while(idxR < right.length) ret[idx++] = right[idxR++];

        return ret;
    }
}