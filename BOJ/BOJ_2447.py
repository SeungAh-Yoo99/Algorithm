N = int(input())
ans = [[]]

"""
# 모두 '*'로 채워진 27x27 배열을 만든다.
for i in range(0, N):
    ans.append([])
    for j in range(0, N):
        ans[i].append('*')

n = N
while (n >= 3):
    for i in range(0, N):
        if (((i % n) // (int(N/3))) == 1):
            for j in range(0, N):
                if (((j % n) // (int(N/3))) == 1):
                    ans[i][j] = ' '
    n = int(N/3)

for i in range(0, N):
    for j in range(0, N):
        print(ans[i][j], end='')
    print()
"""

for i in range(3):
    ans.append([])
    
    # 3x3 패턴 만들기
    for j in range(3):
        if (i == 1) and (j ==1):
            ans[i].append(' ')
        else:
            ans[i].append('*')

if (N != 3):
    n = 9
    while(n <= N):
        # n x (n/3) 패턴 만들기 
        for i in range(int(n/3)):
            for j in range(int(n/3), n):
                ans[i].append(ans[i % int(n/3)][j % int(n/3)])
        # n x (n/3) 패턴을 2번 이어 붙이기
        for i in range(int(n/3), n):
            ans.append([])
            for j in range(n):
                ans[i].append(ans[i % int(n/3)][j % int(n/3)])
        # 패턴의 중앙을 공백 처리하기
        for i in range(int(n/3), int(n/3)*2):
            for j in range(int(n/3), int(n/3)*2):
                ans[i][j] = ' '
        n *= 3

for i in range(N):
    for j in range(N):
        print(ans[i][j], end='')
    print()

"""
재귀 함수 문젠데 재귀로 못풀었다.
"""