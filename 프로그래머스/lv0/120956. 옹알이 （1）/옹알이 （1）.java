class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < babbling.length; i++) {
            int len = 0;
            for(int j = 0; j < 4; j++) {
                // 문자열이 포함되어 있으면
                if(babbling[i].contains(arr[j])) {
                    len += arr[j].length(); // 길이 재기
                }
            }
            // 입력받은 문자열의 길이와 포함되어 있는 문자들의 길이의 합과 같으면 조합어
            if (len == babbling[i].length())
                answer++;
        }
        return answer;
    }
}