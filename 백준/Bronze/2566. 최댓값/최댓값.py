arr = []

for _ in range(9):
    arr.append(list(map(int, input().split())))

max_num = -1
row, col = 0, 0

for i in range(9):
    for j in range(9):
        if max_num < arr[i][j]:
            max_num = arr[i][j]
            row, col = i, j

print(max_num)
print(row + 1, col + 1)