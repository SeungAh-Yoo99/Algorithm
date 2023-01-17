N = int(input())
ans = [[]]

for i in range(3):
    ans.append([])
    for j in range(3):
        if (i == 1) and (j ==1):
            ans[i].append(' ')
        else:
            ans[i].append('*')

if (N != 3):
    n = 9
    while(n <= N):
        for i in range(int(n/3)):
            for j in range(int(n/3), n):
                ans[i].append(ans[i % int(n/3)][j % int(n/3)])
        for i in range(int(n/3), n):
            ans.append([])
            for j in range(n):
                ans[i].append(ans[i % int(n/3)][j % int(n/3)])
        for i in range(int(n/3), int(n/3)*2):
            for j in range(int(n/3), int(n/3)*2):
                ans[i][j] = ' '
        n *= 3

for i in range(N):
    for j in range(N):
        print(ans[i][j], end='')
    print()