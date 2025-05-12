class Solution {
    public int solution(int[] date1, int[] date2) {
        
        // 년 확인
        if(date1[0] < date2[0])
            return 1;
        else if(date1[0] > date2[0])
            return 0;
        else {
            // 월 확인
            if(date1[1] < date2[1])
                return 1;
            else if(date1[1] > date2[1])
                return 0;
            else {
                // 일 확인
                if(date1[2] < date2[2])
                    return 1;
                else
                    return 0;
            }
        }
    }
}