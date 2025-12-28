class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 가장 뒤에 있는 배달지
        int lastDelivery = -1;
        for(int i = n - 1; i >= 0; i--) {
            if(deliveries[i] != 0) {
                lastDelivery = i;
                break;
            }
        }
        
        // 가장 뒤에 있는 수거지
        int lastPickup = -1;
        for(int i = n - 1; i >= 0; i--) {
            if(pickups[i] != 0) {
                lastPickup = i;
                break;
            }
        }
        
        // 맨 뒤 집부터 cap만큼 배달 & 수거
        int dCap, pCap;
        while(lastDelivery >= 0 || lastPickup >= 0) {
            
            answer += Math.max(lastDelivery + 1, lastPickup + 1) * 2;
            
            dCap = cap;
            pCap = cap;
            
            for(int i = lastDelivery; i >= 0; i--) {
                if(deliveries[i] <= dCap) {
                    dCap -= deliveries[i];
                    lastDelivery--;
                }
                else {
                    deliveries[i] -= dCap;
                    break;
                }
            }
            
            for(int i = lastPickup; i >= 0; i--) {
                if(pickups[i] <= pCap) {
                    pCap -= pickups[i];
                    lastPickup--;
                }
                else {
                    pickups[i] -= pCap;
                    break;
                }
            }
        }
        
        return answer;
    }
}