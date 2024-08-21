import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> candidate;
    static Set<Integer> combi;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        // user_id의 응모자 이름들을 char 배열로 바꾸기
        char[][] user_id_arr = new char[user_id.length][];
        for(int i = 0; i < user_id.length; i++) {
            user_id_arr[i] = user_id[i].toCharArray();
        }
        
        // banned_id의 불량 사용자 이름들을 char 배열로 바꾸기
        char[][] banned_id_arr = new char[banned_id.length][];
        for(int i = 0; i < banned_id.length; i++) {
            banned_id_arr[i] = banned_id[i].toCharArray();
        }
        
        // banned_id의 후보들 인덱스 저장 배열
        candidate = new ArrayList<>();
        for(int i = 0; i < banned_id.length; i++) {
            candidate.add(new ArrayList<>());
            
            for(int j = 0; j < user_id.length; j++) {
                if(isCandidate(banned_id_arr[i], user_id_arr[j])) {
                    candidate.get(i).add(j);
                }
            }
        }
        
        // 백트래킹을 통해 후보들의 모든 조합 구하기
        combi = new HashSet<>();
        backTracking(0, 0);
        int answer = combi.size();
        return answer;
    }
    
    private static boolean isCandidate(char[] banned_id, char[] user_id) {
        
        // 길이가 다르면 후보일 수 없음
        if(banned_id.length != user_id.length) return false;
        
        for(int i = 0; i < user_id.length; i++) {
            
            // 가린 문자인 경우 넘어감
            if(banned_id[i] == '*') continue;
            
            // 다른 문자를 찾은 경우
            if(banned_id[i] != user_id[i]) return false;
        }
        
        // 모든 문자가 동일함
        return true;
    }
    
    private static void backTracking(int n, int bitmasking) {
        
        if(n == candidate.size()) {
            combi.add(bitmasking); // 중복된 조합은 거르기 위한 비트마스킹
            return;
        }
        
        // n번 조합을 찾을 차례
        ArrayList<Integer> candi = candidate.get(n);
        for(int i = 0; i < candi.size(); i++) {
            // 이미 다른 제재 아이디의 사용자로 지목된 경우
            if((bitmasking & (1 << candi.get(i))) == (1 << candi.get(i))) {
                continue;   
            }
            // 아직 지목되지 않은 아이디라면
            else backTracking(n + 1, bitmasking + (1 << candi.get(i)));
                
        }
    }
}