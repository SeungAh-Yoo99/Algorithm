import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        StringTokenizer st;
        
        // 오늘 날짜 년, 월, 일 분리
        st = new StringTokenizer(today, ".");
        int[] todayDate = new int[3];
        todayDate[0] = Integer.parseInt(st.nextToken()); // 년
        todayDate[1] = Integer.parseInt(st.nextToken()); // 월
        todayDate[2] = Integer.parseInt(st.nextToken()); // 일
        
        int[] termsMonth = new int['Z' - 'A' + 1]; // 약관 유효기간을 정리한 배열
        for(int i = 0; i < terms.length; i++) {
            // 약관 종류와 유효기간 분리
            st = new StringTokenizer(terms[i]);
            int t = st.nextToken().toCharArray()[0] - 'A'; // 약관 종류 번호
            termsMonth[t] = Integer.parseInt(st.nextToken()); // 유효기간
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            // 날짜와 약관 종류 분리
            st = new StringTokenizer(privacies[i]);
            String d = st.nextToken(); // 날짜
            int t = st.nextToken().toCharArray()[0] - 'A'; // 약관 종류
            
            // 날짜 년, 월, 일 분리
            st = new StringTokenizer(d, ".");
            int[] date = new int[3];
            date[0] = Integer.parseInt(st.nextToken());
            date[1] = Integer.parseInt(st.nextToken());
            date[2] = Integer.parseInt(st.nextToken());
            
            // 보관 가능일 구하기
            int[] lastDate = new int[3];
            int tmp = date[1] + termsMonth[t];
            if(date[2] == 1) {
                tmp -= 1;
                lastDate[2] = 28;
            }
            else lastDate[2] = date[2] - 1;
            
            if(tmp % 12 == 0) {
                lastDate[0] = date[0] + (tmp - 1) / 12;
                lastDate[1] = 12;
            }
            else {
                lastDate[0] = date[0] + tmp / 12;
                lastDate[1] = tmp % 12;
            }
            
            // 보관 가능일이 이미 지났다면 result에 답 저장
            if(todayDate[0] > lastDate[0]) result.add(i + 1);
            else if(todayDate[0] == lastDate[0]) {
                if(todayDate[1] > lastDate[1]) result.add(i + 1);
                else if(todayDate[1] == lastDate[1]) {
                    if(todayDate[2] > lastDate[2]) result.add(i + 1);
                }
            }
        }
        
        // resut를 배열로 변환 후 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}