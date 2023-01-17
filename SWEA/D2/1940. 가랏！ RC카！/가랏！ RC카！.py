T = int(input())
 
for test_case in range(1, T + 1):
    n = int(input())
    spd = 0 # 속도
    dis = 0 # 거리
    
    for i in range(n):
        c = list(map(int, input().split())) # command
 
        if (c[0] == 1): # 가속
            spd += c[1]
        elif (c[0] == 2): # 감속
            spd -= c[1]
            if (spd < 0): # 현재 속도보다 감속할 속도가 더 클 경우,
                spd = 0 # 속도는 0 m/s
 
        dis += spd
    
    print("#{} {}".format(test_case, dis))