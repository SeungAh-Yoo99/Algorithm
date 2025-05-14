class Solution {
    public String solution(int a, int b) {
        
        // 각 월의 일수
        int[] count = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // 요일(1월 1일이 금요일이므로 금요일부터 저장)
        String[] day = new String[] {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        // 월 -> 일로 변경
        int days = 0;
        for(int i = 1; i < a; i++)
            days += count[i];
        days += b;
        
        return day[(days - 1) % 7];
    }
}