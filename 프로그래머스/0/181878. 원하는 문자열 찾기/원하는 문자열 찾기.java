class Solution {
    public int solution(String myString, String pat) {
        
        // 두 문자열의 모든 영문자를 소문자로 변경
        myString = myString.toLowerCase();
        pat = pat.toLowerCase();
        
        if(myString.contains(pat)) return 1;
        else return 0;
    }
}