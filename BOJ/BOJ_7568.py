n = int(input())
physical= []
rank = []

# 몸무게와 키 정보 입력, 모든 등수를 1로 초기화
for i in range(n):
    physical.append(list(map(int, input().split())))
    rank.append(1)

# 자신과 다른 모든 사람과 비교 했을 때, 키와 몸무게 둘 다 자신보다 크면 등수를 +1 한다.
for i in range(n):
    for j in range(n):
        if (physical[i][0] < physical[j][0]) and (physical[i][1] < physical[j][1]):
            rank[i] += 1

# 등수 입력
for i in range(n):
    if (i == n-1):
        print(rank[i])
    else:
        print(rank[i], end=' ')

"""
몸무게와 키 정보가 들어있는 리스트를 처음부터 끝까지 비교하며, 자신보다 큰 덩치를 가진 사람이 있다면 등수 +1을 한다.
등수는 자신보다 덩치가 큰 사람과만 관계가 있으며, 자신과 같거나 작은 사람과는 상관없다.
"""