def hanoi(num, frm, to, other):
    if (num == 0):
        return
    hanoi(num-1, frm, other, to)
    move.append([frm, to])
    hanoi(num-1, other, to, frm)

k = int(input())
move = []
hanoi(k, 1, 3, 2)
print(len(move))
for i in range(len(move)):
    print(move[i][0], move[i][1])


"""
https://www.youtube.com/watch?v=aPYE0anPZqI
"""