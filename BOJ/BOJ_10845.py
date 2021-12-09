from collections import deque
import sys

dq = deque()

def dq_push(num):
    dq.append(num)

def dq_pop():
    if dq:
        print(dq.popleft())
    else:
        print(-1)

def dq_size():
    print(len(dq))

def dq_empty():
    if dq:
        print(0)
    else:
        print(1)

def dq_front():
    if dq:
        print(dq[0])
    else:
        print(-1)

def dq_back():
    if dq:
        print(dq[-1])
    else:
        print(-1)

functions = {'push': dq_push,
            'pop': dq_pop,
            'size': dq_size,
            'empty': dq_empty,
            'front': dq_front,
            'back': dq_back}

n = int(sys.stdin.readline())

for _ in range(n):
    cmd = list(map(str, sys.stdin.readline().split()))

    func = functions[cmd[0]]

    if cmd[0] =='push':
        func(cmd[1])
    else:
        func()