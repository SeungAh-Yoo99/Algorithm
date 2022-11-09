str = "abcdefghijklmnopqrstuvwxyz"

t = int(input())

for test_case in range(1, t + 1):
    input_str = input()

    # 순서에 맞게 적힌 알파벳 개수
    count = 0
    for i in range(len(input_str)):
        # 순서에 맞게 적혔다면 count + 1
        if str[i] == input_str[i]:
            count += 1
        # 순서가 틀린 알파벳이 나왔다면 반복문 탈출
        else:
            break

    print("#{} {}".format(test_case, count))