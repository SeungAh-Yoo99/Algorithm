n, m = map(int, input().split())

S = []
for _ in range(n):
    S.append(input())

count = 0
for _ in range(m):
    string = input()
    if string in S:
        count += 1

print(count)