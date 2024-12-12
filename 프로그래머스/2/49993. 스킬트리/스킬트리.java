class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        // skill의 길이가 1이면 모든 경우가 가능
        if(skill.length() == 1) return skill_trees.length;
        
        // 위상정렬
        int[] pre = new int[26];
        for(int i = 1; i < skill.length(); i++) {
            pre[skill.charAt(i) - 'A']++;
        }
        
        int pointer; int[] clone_pre;
        int answer = 0;
        for(String tree : skill_trees) {
            pointer = 0;
            clone_pre = pre.clone();
        
            for(int i = 0; i < tree.length(); i++) {
                
                // 현재 스킬의 선행 스킬이 남아있다면, 불가능한 스킬 트리
                if(clone_pre[tree.charAt(i) - 'A'] != 0) break;
                
                // 마지막 스킬이면 가능한 경우
                if(i == tree.length() - 1) {
                    answer++;
                    break;
                }
                
                // 현재 스킬이 pointer가 가리키는 스킬이라면
                if(skill.charAt(pointer) == tree.charAt(i)) {
                    pointer++;
                    
                    // 모든 선행 스킬을 다 배웠으면 가능한 경우
                    if(pointer == skill.length()) {
                        answer++;
                        break;
                    }
                    
                    // 포인터가 가리키고 있는 스킬의 선행스킬 다 배움
                    clone_pre[skill.charAt(pointer) - 'A']--;
                }
            }
        }
        
        return answer;
    }
}