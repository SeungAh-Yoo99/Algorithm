T = int(input())

for test_case in range(1, T + 1):
    sudoku = [list(map(int, input().split())) for _ in range(9)]

    isSudoku = 1
    #가로줄
    for i in range(9):
        #set의 특성을 이용해서 중복 제거 후 list로 변환
        arr = list(set(sudoku[i]))
        #중복이 있어서 arr의 길이가 줄어들었다면
        if len(arr) != 9:
            isSudoku = 0

    #세로줄
    #list를 90도 회전해서 확인
    sudoku_zip = list(zip(*sudoku[::-1]))
    for i in range(9):
        arr = list(set(sudoku_zip[i]))
        if len(arr) != 9:
            isSudoku = 0

    #3x3 확인
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            arr = [sudoku[i][j], sudoku[i][j + 1], sudoku[i][j + 2],
            sudoku[i + 1][j], sudoku[i + 1][j + 1], sudoku[i + 1][j + 2],
            sudoku[i + 2][j], sudoku[i + 2][j + 1], sudoku[i + 2][j + 2]]

            arr = list(set(arr))
            if len(arr) != 9:
                isSudoku = 0

    print("#{} {}".format(test_case, isSudoku))