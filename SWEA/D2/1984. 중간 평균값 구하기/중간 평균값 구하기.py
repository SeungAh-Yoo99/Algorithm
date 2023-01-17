T = int(input())
 
for test_case in range(1, T + 1):
    numList = list(map(int, input().split()))
 
    #sorted 함수 사용
    avg = round(sum(sorted(numList)[1:9]) / 8)
 
    print("#{} {}".format(test_case, avg))