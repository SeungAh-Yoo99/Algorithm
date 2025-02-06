class Solution {
    public int solution(String str1, String str2) {
        
        for(int i = 0; i <= str2.length() - str1.length(); i++) {
            if(str1.equals(str2.substring(i, i + str1.length()))) return 1;
        }
        
        return 0;
    }
}