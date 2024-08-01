import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // 두 배열 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        // A 배열에서는 현재 가능한 가장 작은 수
        // B 배열에서는 현재 가능한 가장 큰 수를 골라 곱함
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}