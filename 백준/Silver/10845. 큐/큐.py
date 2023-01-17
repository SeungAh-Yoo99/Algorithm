import sys
n=int(input())
do=[]
queue=[]
for _ in range(n):
    do.append(sys.stdin.readline().split())
for i in range(n):
    if do[i][0]=='push':
        queue.append(do[i][1])
    if do[i][0]=='pop':
        if len(queue):
            print(queue.pop(0))
        else:
            print(-1)
    if do[i][0]=='size':
        print(len(queue))
    if do[i][0]=='empty':
        if len(queue):
            print(0)
        else:
            print(1)
    if do[i][0]=='front':
        if len(queue):
            print(queue[0])
        else:
            print(-1)
    if do[i][0]=='back':
        if len(queue):
            print(queue[-1])
        else:
            print(-1)