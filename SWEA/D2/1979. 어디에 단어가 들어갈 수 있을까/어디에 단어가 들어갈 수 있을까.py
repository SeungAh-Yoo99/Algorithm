T = int(input())
 
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
 
    puzzle = [list(map(int, input().split())) for _ in range(N)]
 
    #가능한 단어 갯수 카운트
    count = 0
    
    #가로부터 확인
    for i in range(N):
        #1이 반복해서 나온 횟수
        word = 0
        for j in range(0, N):
            #해당 칸이 1이면 단어 길이 +1
            if puzzle[i][j] == 1:
                word += 1
            #0이면
            else:
                #전 칸까지 연속된 1의 길이가 K였다면 count +1
                if word == K:
                    count += 1
                #word를 다시 0으로 세팅
                word = 0
        #줄바꿈이 있을 때, 마지막 칸이 1 연속 K칸이었다면 count +1
        if word == K:
            count += 1
 
    #세로 확인(가로와 같은 방법으로)
    for i in range(N):
        word = 0
        for j in range(0, N):
            if puzzle[j][i] == 1:
                word += 1
            else:
                if word == K:
                    count += 1
                word = 0
        if word == K:
            count += 1
 
    print("#{} {}".format(test_case, count))