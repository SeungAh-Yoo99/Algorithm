for _ in range(10):
    test_case = int(input())
 
    # 2차원 배열 생성
    arr = []
 
    # 배열 입력
    for i in range(100):
        arr.append(list((map(int, input().split()))))
 
    column = 0 # 행의 합
    row = 0 # 열의 합
    diagonal_down =0 # 위에서 아래로 향하는 대각선의 합
    diagonal_up = 0 # 아래에서 위로 향하는 대각선의 합
    result = 0 # 답
 
    for i in range(100):
        for j in range(100):
            column += arr[j][i]
            row += arr[i][j]
        diagonal_down += arr[i][i]
        diagonal_up += arr[99 - i][i]
 
        if result < column:
            result = column
        column = 0
 
        if result < row:
            result = row
        row = 0
 
    if result < diagonal_down:
        result = diagonal_down
    if result < diagonal_up:
        result = diagonal_up
 
    print("#{} {}".format(test_case, result))