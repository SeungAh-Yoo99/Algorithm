# test case tc
tc = int(input())
 
for test_case in range(1, tc + 1):
	# 통나무 길이 n
    n = int(input())
 
    if n % 2 == 0:
        print("#{} Alice".format(test_case))
    else:
        print("#{} Bob".format(test_case))