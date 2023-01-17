T = int(input())
 
for test_case in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
 
    print("#{}".format(test_case))
 
    arrList = []
    #90도 회전
    arrList.append(list(zip(*arr[::-1])))
    #180도 회전
    arrList.append(list(zip(*arrList[0][::-1])))
    #270도 회전
    arrList.append(list(zip(*arrList[1][::-1])))
    
    for x in range(N):
        for y in range(3):
            for z in range(N):
                print(arrList[y][x][z], end="")
            print(" ", end="")
        print()