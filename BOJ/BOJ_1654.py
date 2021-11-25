import sys

k, n = map(int, input().split())
lines = [int(sys.stdin.readline()) for _ in range(k)]

start = 1
end = sum(lines) // n # 라인의 길이의 최대, 이 길이를 넘으면 n만큼 가져올 수 없음
    
while start <= end:
    mid = (start + end) //2
    cnt = 0
    for line in lines:
        cnt += line // mid
    
    # 이 경우 라인의 길이를 좀 더 크게 해도 됨
    if cnt >= n:
        start = mid + 1
    # 이 경우 라인의 길이를 좀 더 줄여야 됨
    else:
        end = mid - 1
        
print(end)