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
                st = new StringTokenizer(s.substring(start + 1, end), ",");
                list = new ArrayList<>();
                while(st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
                map.put(list.size(), list);
            }
        }
        
        int[] answer = new int[map.size()];
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= map.size(); i++) {
            list = map.get(i);
            for(int j = 0; j < list.size(); j++) {
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