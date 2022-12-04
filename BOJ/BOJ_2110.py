n, c = map(int, input().split())

arr = []
for _ in range(n):
    arr.append(int(input()))
arr.sort()

start, end = 1, arr[n - 1] - arr[0]
result = 0 # 답

# 공유기의 개수가 2개라면 양 끝에 설치
if c == 2:
    result = arr[n - 1] - arr[0]
else:
    while (start < end):
        last = arr[0] # 마지막에 설치한 공유기 위치
        count = 1 # 설치한 공유기 수

        mid = (start + end) // 2

        # mid만큼의 간격을 유지하며 공유기 설치
        for i in range(1, n):
            if arr[i] - last >= mid:
                count += 1
                last = arr[i]

        # mid만큼의 간격을 유지하며 공유기를 설치했을 때,
        # c보다 설치할 수 있는 공유기 수가 더 많을 때만 result에 저장하고
        # 간격을 늘려본다.
        if count >= c:
            start = mid + 1
            result = mid
        # c보다 설치할 수 있는 공유기 수가 더 적다면,
        # 간격을 줄여본다.
        else:
            end = mid

print(result)