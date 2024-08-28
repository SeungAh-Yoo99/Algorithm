class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while(a / 2 + (a % 2 == 0 ? 0 : 1) != b / 2 + (b % 2 == 0 ? 0 : 1)) { // a와 b가 같은 팀인지 확인
            
            // 다음 라운드에서 a와 b의 번호
            a = a / 2 + (a % 2 == 0 ? 0 : 1);
            b = b / 2 + (b % 2 == 0 ? 0 : 1);
            
            // 한 판 더
            answer++;
        }

        return answer;
    }
}