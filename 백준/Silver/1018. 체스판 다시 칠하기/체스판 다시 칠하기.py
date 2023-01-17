def numOfRepainting(chessBoard):
    stayNum, changeNum = 0, 0 # 처음 색을 바꿨을 때 변경해야 할 횟수, 바꾸지 않았을 때 변경해야 할 횟수
    # 처음 색을 바꾸지 않는다면
    for i in range(8):
            for j in range(8):
                if (i % 2 == 0 and j % 2 == 1) or (i % 2 == 1 and j % 2 == 0): # 처음 색과 다른 색이 와야 하는 부분
                    if (chessBoard[0][0] == chessBoard[i][j]):
                        stayNum += 1
                else: # 처음 색과 같은 색이 와야 하는 부분
                    if (chessBoard[0][0] != chessBoard[i][j]):
                        stayNum += 1

    # 처음 색을 바꾼다면 (실제 배열에서는 값을 바꾸지 않지만, 바꾸었다고 가정)
    for i in range(8):
        for j in range(8):
            if (i % 2 == 0 and j % 2 == 1) or (i % 2 == 1 and j % 2 == 0): # 처음 색과 다른 색이 와야 하는 부분 (실제로 처음의 값을 바꾸지 않았으니 처음 색과 같은 색이 와야 함.)
                if (chessBoard[0][0] != chessBoard[i][j]):
                    changeNum += 1
            else: # 처음 색과 같은 색이 와야 하는 부분 (실제로 처음의 값을 바꾸지 않았으니 처음 색과 다른 색이 와야 함.)
                if (chessBoard[0][0] == chessBoard[i][j]):
                    changeNum += 1

    return min(stayNum, changeNum)


n, m = map(int, input().split())
board = []
num = []

for i in range(n):
    board.append(list(map(str, str(input()))))

for i in range(n-7): # 밑으로 7개의 칸이 더 남아 있어야 한다.
    for j in range(m-7): # 옆으로 7개의 칸이 더 남아 있어야 한다.
        chessBoard = []
        for x in range(i, i+8):
            chessBoard.append(board[x][j:j+8])
        num.append(numOfRepainting(chessBoard))

print(min(num))