T = int(input())

for test_case in range(1, T + 1):
    lst = map(int, input().split())

    # max_lst = max(lst)
    
    max_lst = 0

    for l in lst:
        if max_lst < l:
            max_lst = l

    print("#{} {}".format(test_case, max_lst))