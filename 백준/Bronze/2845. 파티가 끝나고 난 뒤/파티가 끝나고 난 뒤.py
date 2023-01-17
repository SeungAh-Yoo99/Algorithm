L, P = map(int, input().split())

articleNum = list(map(int, input().split()))
difference = []

for i in articleNum:
    difference.append(i - L * P)

for i in difference:
    print(i, end=' ')