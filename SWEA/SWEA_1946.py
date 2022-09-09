T = int(input())

for test_case in range(1, T + 1):
    N = int(input())

    # charList = []
    text = ""
    for _ in range(N):
        c, k = input().split()

    #     #문자 c를 k개만큼 charList에 넣는다
    #     for i in range(int(k)):
    #         charList.append(c)

    # print("#{}".format(test_case), end="")
    # #charList 안의 문자들을 10개 씩 한 줄에 출력
    # for i in range(len(charList)):
    #     if i % 10 == 0:
    #         print()
    #     print(charList[i], end="")
    # print()

        text += c * int(k)

    print("#{}".format(test_case))
    for i in range(0, len(text), 10):
        print(text[i:i+10])
