class Solution {
    public int solution(int[] common) {
        int answer = 0;
        boolean isAp = true; // 등차수열일 경우 true

        // 등차수열인지 체크
        int sub = common[1] - common[0];
        for(int i = 2; i < common.length; i++) {
            if (sub != common[i] - common[i - 1]) {
                isAp = false;
                break;
            }
        }

        // 등차수열이라면 마지막 원소에서 sub만큼 더해준 값이 result
        if(isAp) {
            answer = common[common.length - 1] + sub;
        }
        // 등비수열이라면, common의 1번째 원소를 0번째 원소로 나눴을 때의 몫을 마지막 원소에 곱해주면 result
        else {
            int mul = (int)(common[1] / common[0]);
            answer = common[common.length - 1] * mul;
        }
            return answer;
        }
}