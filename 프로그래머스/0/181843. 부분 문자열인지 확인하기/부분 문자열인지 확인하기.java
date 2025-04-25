class Solution {
    public int solution(String my_string, String target) {
        
        // target 문자열이 더 길다면
        // target은 my_string의 부분 문자열이 아니다
        if(target.length() > my_string.length())
            return 0;
        
        for(int i = 0; i <= my_string.length() - target.length(); i++) {
            if(my_string.substring(i, i + target.length()).equals(target))
                return 1;
        }

        return 0;
    }
}