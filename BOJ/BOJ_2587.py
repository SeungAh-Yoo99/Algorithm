arr = []
for _ in range(5):
    arr.append(int(input()))

rvg = sum(arr) // 5

arr.sort()
mid = arr[2]

print(rvg)
print(mid)