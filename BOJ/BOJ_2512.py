n = int(input())
arr = list(map(int, input().split()))
m = int(input())

start, end = 1, max(arr)
result = 0

if sum(arr) <= m:
    result = max(arr)
else:
    while(start < end):
        mid = (start + end) // 2

        sum = 0
        for i in range(n):
            if arr[i] <= mid:
                sum += arr[i]
            else:
                sum += mid
        
        if sum <= m:
            result = mid
            start = mid + 1
        else:
            end = mid

print(result)