class Solution {
    public int solution(int[] wallet, int[] bill) {
        
        int tmp;
        
        // wallet의 긴 쪽이 0 번 인덱스에 오도록 정렬
        if(wallet[0] < wallet[1]) {
            tmp = wallet[0];
            wallet[0] = wallet[1];
            wallet[1] = tmp;
        }
        
        int answer = 0;
        
        while(true) {
            // 항상 지폐의 긴 쪽이 0번 인덱스에 오도록 유지
            if(bill[0] < bill[1]) {
                tmp = bill[0];
                bill[0] = bill[1];
                bill[1] = tmp;
            }
            
            // 지갑에 들어가는지 확인
            if(bill[0] <= wallet[0] && bill[1] <= wallet[1]) break;
            
            // 반으로 접기
            bill[0] /= 2;
            answer++;
        }
    
        return answer;
    }
}