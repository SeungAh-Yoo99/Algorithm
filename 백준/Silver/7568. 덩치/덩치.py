n = int(input())
physical= []
rank = []

for i in range(n):
    physical.append(list(map(int, input().split())))
    rank.append(1)

for i in range(n):
    for j in range(n):
        if (physical[i][0] < physical[j][0]) and (physical[i][1] < physical[j][1]):
            rank[i] += 1

for i in range(n):
    if (i == n-1):
        print(rank[i])
    else:
        print(rank[i], end=' ')