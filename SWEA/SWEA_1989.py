T = int(input())

for test_case in range(1, T + 1):
    str = input()

    isPalindrome = True
    for i in range(len(str) // 2):
        #회문 조건이 깨지면
        if str[i] != str[-1 - i]:
            isPalindrome = False
            break

    if isPalindrome:
        print("#{} 1".format(test_case))
    else:
        print("#{} 0".format(test_case))