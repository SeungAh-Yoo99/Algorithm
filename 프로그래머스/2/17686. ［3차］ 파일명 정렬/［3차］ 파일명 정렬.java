import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        // HEAD, NUMBER, TAIL 나누기
        String[][] split = new String[files.length][4];
        
        int idx;
        for(int i = 0; i < files.length; i++) {
            split[i][0] = new Integer(i).toString();
            idx = 0;
            for(int j = 0; j < files[i].length(); j++) {
                if(idx == 0 && files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
                    split[i][1] = files[i].substring(0, j).toUpperCase();
                    idx = j;
                }
                else if(idx != 0 && (files[i].charAt(j) < '0' || files[i].charAt(j) > '9')){
                    split[i][2] = files[i].substring(idx, j);
                    split[i][3] = files[i].substring(j, files[i].length());
                    break;
                }
            }
            if(split[i][2] == null) split[i][2] = files[i].substring(idx, files[i].length());
        }
        
        // 정렬
        Arrays.sort(split, (o1, o2) -> o1[1].equals(o2[1])
                   ? Integer.parseInt(o1[2]) - Integer.parseInt(o2[2])
                   : o1[1].compareTo(o2[1]));
        
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++) {
            answer[i] = files[Integer.parseInt(split[i][0])];
        }
        
        return answer;
    }
}