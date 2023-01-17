t = int(input())

s = []
ans = []
for i in range(0, t):
    s.append(input())
    ans.append('NO')

for i in range(0, t):
    n = 0
    for j in range(0, len(s[i])):
        if s[i][j] == '(':
            n += 1
        elif s[i][j] == ')':
            n -= 1

        if n < 0:
            break

    if n == 0:
        ans[i] = 'YES'

for i in range(0, t):
    print(ans[i])