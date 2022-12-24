n, m = map(int, input().split())

arr1 = []
for _ in range(n):
    arr1.append(input())

arr2 = []
for _ in range(m):
    arr2.append(input())

ans = sorted(list(set(arr1) & set(arr2)))
print(len(ans))
for name in ans:
    print(name)