import sys

k, n = map(int, input().split())
lines = [int(sys.stdin.readline()) for _ in range(k)]
# 라인의 길이의 최대, 이 길이를 넘으면 n만큼 가져올 수 없음
start = 1
end = sum(lines) // n
    
while start <= end:
    mid = (start + end) //2
    cnt = 0
    for line in lines:
        cnt += line // mid
        
    if cnt >= n:
        start = mid + 1
    else:
        end = mid - 1
        
print(end)