T = int(input())

for test_case in range(1, T + 1):
    lst = map(int, input().split())
    # avg = 0
    
    # for l in lst:
    #     avg += l

    # avg /= 10

    # print("#" + str(test_case), round(avg))
    
    avg = round(sum(lst) / 10)
    
    print("#{} {}".format(test_case, avg))