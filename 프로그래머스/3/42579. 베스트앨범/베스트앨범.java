import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르 별 수록 총합
        ArrayList<int[]> playsPerGenres = new ArrayList<>();
        
        // 장르 인덱스 정보
        Map<String, Integer> genresInfoStrToInt = new HashMap<>();
        Map<Integer, String> genresInfoIntToStr = new HashMap<>();
        
        // 장르 별 수록 수 상위 2개의 곡 저장
        Map<String, int[]> top2PerGenres = new HashMap<>();
        
        // 곡 정보를 확인하며 정보 저장
        int genreIndex; int[] tmp;
        for(int i = 0; i < genres.length; i++) {
            // 새로운 장르 확인
            if(genresInfoStrToInt.get(genres[i]) == null) {
                genresInfoStrToInt.put(genres[i], playsPerGenres.size()); // 새로운 장르 인덱스 정보 저장
                genresInfoIntToStr.put(playsPerGenres.size(), genres[i]);
                playsPerGenres.add(new int[] {playsPerGenres.size(), plays[i]}); // 새로운 장르의 총합 저장
                top2PerGenres.put(genres[i], new int[] {i, -1}); // 새로운 장르의 많이 재생된 노래 top2에 정보 저장
            }
            // 이미 확인된 적 있는 장르
            else {
                genreIndex = genresInfoStrToInt.get(genres[i]); // 장르의 인덱스 정보
                tmp = playsPerGenres.get(genreIndex); // 장르의 총합 정보 가져오기
                tmp[1] += plays[i]; // 장르의 총합에 현재 곡 재생 수 더하기
                
                tmp = top2PerGenres.get(genres[i]); // 장르의 top2 정보 가져오기
                // 상위 1위라면
                if(plays[tmp[0]] < plays[i]) {
                    tmp[1] = tmp[0];
                    tmp[0] = i;
                }
                // 상위 2위라면
                else if(tmp[1] == -1 || plays[tmp[1]] < plays[i]) {
                    tmp[1] = i;
                }
            }
        }
        
        // 장르별 재생 수 정렬
        Collections.sort(playsPerGenres, (o1, o2) -> o2[1] - o1[1]);
        
        // 기준에 맞춰 답에 담기
        ArrayList<Integer> result = new ArrayList<>();
        String genre; int[] top2;
        for(int i = 0; i < playsPerGenres.size(); i++) {
            genre = genresInfoIntToStr.get(playsPerGenres.get(i)[0]); // 장르 이름 가져오기
            top2 = top2PerGenres.get(genre); // 상위 2개곡 정보 가져오기
            // genre의 상위 1위 재생곡 넣기
            result.add(top2[0]);
            // genre의 상위 2위 재생곡 넣기
            if(top2[1] != -1) result.add(top2[1]);
        }
        
        // answer 배열에 다시 담기
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        return answer;
    }
}