N = int(input())
cons = 0

for i in range(1, N+1):
    # i의 각 자릿수를 sumDigit에 저장
    sumDigit = list(map(int, str(i)))
    cons = i + sum(sumDigit)
    if (N == cons):
        print(i)
        break

if (i == N):
    print(0)