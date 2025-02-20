class Solution {
    public String solution(String[] id_pw, String[][] db) {
        
        for(int i = 0; i < db.length; i++) {
            if(db[i][0].equals(id_pw[0])) { // 같은 아이디 발견
                // 비밀번호가 일치한다면
                if(db[i][1].equals(id_pw[1])) return "login";
                // 비밀번호가 일치하지 않는다면
                else return "wrong pw";
            }
        }
        
        // 일치하는 회원이 없다면
        return "fail";
    }
}