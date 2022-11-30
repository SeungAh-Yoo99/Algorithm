n, k = map(int, input().split())

arr = []
for _ in range(n):
    arr.append(int(input()))

count = 0
for i in range(n - 1, -1, -1):
    count += k // arr[i]
    k = k % arr[i]

print(count)