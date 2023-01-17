# test case 개수 t
t = int(input())
 
for test_case in range(1, t + 1):
    # 재료의 수 n, 제한 칼로리 l
    n, l = map(int, input().split())
    
    # 재료의 맛에 대한 점수, 칼로리
    ingredient = []
    for _ in range(n):
        score, cal = map(int, input().split())
        ingredient.append((score, cal))
 
    # 누적 점수와 칼로리를 담을 배열
    result = [[] for _ in range(n)]
 
    # 다른 재료들과의 조합 중,
    # 칼로리가 l을 넘지 않는 모든 조합을 result에 저장
    for i in range(n):
        result[i].append(ingredient[i])
        for j in range(0, i):
            for k in result[j]:
                score, cal = k
                if cal + ingredient[i][1] <= l:
                    result[i].append((score + ingredient[i][0], cal + ingredient[i][1]))   
 
    # 가장 큰 score 구하기
    max_score = 0
    for i in range(n):
        for j in result[i]:
            score, cal = j
            if score > max_score:
                max_score = score
 
    print("#{} {}".format(test_case, max_score))
