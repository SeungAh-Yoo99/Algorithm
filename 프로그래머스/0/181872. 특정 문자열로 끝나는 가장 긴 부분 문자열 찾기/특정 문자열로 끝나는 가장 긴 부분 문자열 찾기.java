class Solution {
    public String solution(String myString, String pat) {
        
        // 뒤에서부터 pat과 동일한 부분문자열 시작 위치 찾기
        for(int i = myString.length() - pat.length(); i >= 0; i--) {
            if(myString.substring(i, i + pat.length()).equals(pat))
                return myString.substring(0, i + pat.length());
        }
        
        return "";
    }
}