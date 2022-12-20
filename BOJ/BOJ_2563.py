n = int(input())

# 도화지를 나타내는 2차배열
# 0이 색종이가 붙지 않은 영역
# 1이 색종이가 붙은 영역
arr = [[0] * 100 for _ in range(100)]

for _ in range(n):
    x, y = map(int, input().split())
    for i in range(10):
        for j in range(10):
            arr[x + i][y + j] = 1

# 색종이가 붙은 영역의 넓이
area = 0
for i in range(100):
    for j in range(100):
        if arr[i][j] == 1:
            area += 1

print(area)