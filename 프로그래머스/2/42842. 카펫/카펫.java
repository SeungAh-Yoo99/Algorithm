class Solution {
    public int[] solution(int brown, int yellow) {
        /**
        * yellow의 가로 길이 = x, 세로 길이 = y일때
        * yellow = x * y
        * brown = (2 * x) + (2 * y) + 4
        *
        * 완전탐색으로 가능한 x와 y를 구한다.
        * x와 y는 yellow의 가로, 세로 길이이기 때문에 answer는 +2 씩 되어야 한다.
        */
        
        int[] answer = new int[2];
        
        int y;
        for(int x = 1; x <= yellow; x++) {
            // x가 yellow의 약수인 경우에만 확인
            if(yellow % x != 0) continue;
            
            y = yellow / x;
            
            if(brown == 2 * x + 2 * y + 4) {
                if(x > y) answer = new int[] {x + 2, y + 2};
                else answer = new int[] {y + 2, x + 2};
                break;
            }
        }

        return answer;
    }
}