class Solution {
    public int solution(String myString, String pat) {
        
        StringBuilder change = new StringBuilder();
        for(int i = 0; i < myString.length(); i++) {
            if(myString.charAt(i) == 'A') change.append("B");
            else change.append("A");
        }
        
        if(change.toString().contains(pat)) return 1;
        else return 0;
    }
}