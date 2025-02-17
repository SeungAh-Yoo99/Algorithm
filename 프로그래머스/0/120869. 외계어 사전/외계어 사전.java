import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        
        // spell에 사용된 문자 개수 세기
        int[] count = new int['z' - 'a' + 1];
        for(int i = 0; i < spell.length; i++)
            count[spell[i].charAt(0) - 'a']++;
        
        int[] tmp = new int['z' - 'a' + 1];
        boolean flag;
        for(int i = 0; i < dic.length; i++) {
            // 단어 길이가 맞지 않으면 다음 단어 확인하러
            if(dic[i].length() != spell.length) continue;
            
            // dic[i]에 사용된 문자 개수 세기
            Arrays.fill(tmp, 0);
            for(int j = 0; j < spell.length; j++)
                tmp[dic[i].charAt(j) - 'a']++;
            
            // spell과 동일한 조합인지 확인
            flag = true;
            for(int j = 0; j < count.length; j++) {
                if(count[j] != tmp[j]) {
                    flag = false;
                    break;
                }
            }
            
            // 동일한 조합이라면 리턴
            if(flag) return 1;
        }
        
        return 2;
    }
}