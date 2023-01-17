T = int(input())
 
for test_case in range(1, T + 1):
    lst = map(int, input().split())
 
    avg = round(sum(lst) / 10)
    
    print("#{} {}".format(test_case, avg))