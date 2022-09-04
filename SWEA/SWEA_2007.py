T = int(input())

for test_case in range(1, T + 1):
    s = input()

    for i in range(1, 11):
        if s[:i] == s[i:i+i]:
            #위 마디가 반복하는게 맞는지 확인
            is_repeat = True
            for m in range(i, len(s)):
                #반복하는게 맞다면 배수 자리에 항상 같은 문자열이 와야함.
                if s[m % i] != s[m]:
                    is_repeat = False
                    break

            if is_repeat:       
                print("#{} {}".format(test_case, i))
                break