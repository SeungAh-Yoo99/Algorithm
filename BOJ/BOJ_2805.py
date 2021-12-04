# pypy3

n, m = map(int, input().split())

woods = list(map(int, input().split()))

start, end = 0, max(woods)

while (start <= end):
    stick = 0 # 가져갈 수 있는 나무 길이
    mid = (start + end) // 2
    
    for wood in woods:
        if wood > mid: # 나무 길이가 절단기 높이보다 클 경우
            stick += wood - mid
    
    if stick >= m: # 가져갈 수 있는 나무 길이가 더 길면
        start = mid + 1 # 절단기 높이를 올려주어야 함
    else: # 더 작으면
        end = mid - 1 # 절단기 높이를 낮춰 주어야 함.
    
print(end)