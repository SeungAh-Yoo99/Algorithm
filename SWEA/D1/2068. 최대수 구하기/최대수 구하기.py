T = int(input())
 
for test_case in range(1, T + 1):
    lst = map(int, input().split())
 
    max_lst = max(lst)
 
    print("#{} {}".format(test_case, max_lst))