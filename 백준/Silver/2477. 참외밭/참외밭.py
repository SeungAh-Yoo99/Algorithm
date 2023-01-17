k = int(input())

# 큰 사각형에서 작은 사각형을 빼서 면적을 구한다.

# 작은 사각형의 면적은
# 동(1) -> 남(3) -> 동(1) 으로 이동 했다면 동 -> 남 으로 이동했을 때의 변의 길이로 구함.
# 서(2) -> 북(4) -> 서(2) 라면 서 -> 북
# 남(3) -> 서(2) -> 남(3) 라면 남 -> 서
# 북(4) -> 동(1) -> 북(4) 라면 북 -> 동 으로 이동했을 때의 변의 길이로 구함.

arr = []
for _ in range(6):
    a, b = map(int, input().split())
    arr.append((a, b))

# 큰 사각형의 가로, 세로 구하기
big_width, big_height = 0, 0
for i in range(6):
    if arr[i][0] == 1 or arr[i][0] == 2:
        big_width = max(big_width, arr[i][1])
    else:
        big_height = max(big_height, arr[i][1])

# 작은 사각형의 가로, 세로 구하기
small_width, small_height = 0, 0
for i in range(6):
    # 동(1) -> 남(3) -> 동(1) 으로 이동 했다면
    if arr[i][0] == 1 and arr[i + 1][0] == 3 and arr[i + 2][0] == 1:
        # 동 -> 남 으로 이동했을 때의 변의 길이
        small_width = arr[i][1]
        small_height = arr[i + 1][1]
    # 서(2) -> 북(4) -> 서(2)
    elif arr[i][0] == 2 and arr[i + 1][0] == 4 and arr[i + 2][0] == 2:
        # 서 -> 북 으로 이동했을 때의 변의 길이
        small_width = arr[i][1]
        small_height = arr[i + 1][1]
    # 남(3) -> 서(2) -> 남(3)
    elif arr[i][0] == 3 and arr[i + 1][0] == 2 and arr[i + 2][0] == 3:
        # 남 -> 서 으로 이동했을 때의 변의 길이
        small_width = arr[i + 1][1]
        small_height = arr[i][1]
    # 북(4) -> 동(1) -> 북(4)
    elif arr[i][0] == 4 and arr[i + 1][0] == 1 and arr[i + 2][0] == 4:
        # 북 -> 동 으로 이동했을 때의 변의 길이
        small_width = arr[i + 1][1]
        small_height = arr[i][1]

    arr.append(arr[i])
    

# 밭의 면적
area = big_width * big_height - small_width * small_height
# 자라는 참외의 수
ans = area * k

print(ans)