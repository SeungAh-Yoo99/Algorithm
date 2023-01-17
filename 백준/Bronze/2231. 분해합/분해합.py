N = int(input())
cons = 0

for i in range(1, N+1):
    sumDigit = list(map(int, str(i)))
    cons = i + sum(sumDigit)
    if (N == cons):
        print(i)
        break

if (i == N):
    print(0)