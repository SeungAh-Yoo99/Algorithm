import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int start, end;
        StringTokenizer st;
        ArrayList<Integer> list;
        Map<Integer, ArrayList> map = new HashMap<>();
        for(int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i) == '{') {
                start = i;
                while(s.charAt(++i) != '}');
                end = i;
                // {} 안의 수들을 ","를 기준으로 분할
                st = new StringTokenizer(s.substring(start + 1, end), ",");
                // 분할한 수들을 리스트에 담기
                list = new ArrayList<>();
                while(st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
                // 리스트 길이를 key값으로 Map에 담기
                map.put(list.size(), list);
            }
        }
        
        int[] answer = new int[map.size()];
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= map.size(); i++) {
            // 리스트 길이가 짧은 순으로 가져오기
            list = map.get(i);
            for(int j = 0; j < list.size(); j++) {
                // 이미 확인한 수는 넘어가기
                if(!set.contains(list.get(j))) {
                    set.add(list.get(j));
                    answer[i - 1] = list.get(j);
                    break;
                }
            }
            
        }
        return answer;
    }
}
