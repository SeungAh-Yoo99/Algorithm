t = int(input())
 
for test_case in range(1, t + 1):
    chessboard = [list(input()) for _ in range(8)]
    rotated_chessboard = list(zip(*chessboard[::-1]))
    result = True
 
    for i in range(8):
        # 가로줄에도 'O'가 하나여야 하고
        if chessboard[i].count('O') != 1:
            result = False
            break
        # 세로줄에도 'O'가 하나여야 한다
        if rotated_chessboard[i].count('O') != 1:
            result = False
            break
 
    if result:
        print("#{} yes".format(test_case))
    else:
        print("#{} no".format(test_case))