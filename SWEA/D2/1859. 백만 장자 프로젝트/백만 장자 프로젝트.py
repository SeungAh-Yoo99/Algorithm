T = int(input())
 
for test_case in range(1, T + 1):
    N = int(input())
    N_list = list(map(int, input().split()))
 
    max_price = N_list[-1] #마지막 날 매매가를 최대로 설정
    profit = 0 #이익
    for d in range(N - 2, -1, -1):
        #전날 매매가가 더 적으면
        if max_price > N_list[d]:
           profit += max_price - N_list[d] #이익 계산
        #전날 매매가가 더 크거나 같으면
        else:
            max_price = N_list[d]
 
    print("#{} {}".format(test_case, profit))