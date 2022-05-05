T = int(input())

for test_case in range(1, T + 1):
    date = input()
    y = date[:4]
    m = date[4:6]
    d = date[6:]

    # month가 1~12이 아니라면 -1 출력 후 다음 case로
    if (not(1 <= int(m) <= 12)):
        print("#{} -1".format(test_case))
        continue

    # 1, 3, 5, 7, 8, 10, 12월일때
    if (int(m) in [1, 3, 5, 7, 8, 10, 12]):
        # day가 1~31이 아니라면 -1 출력 후 다음 case로
        if (not(1 <= int(d) <= 31)):
            print("#{} -1".format(test_case))
            continue
    # 2월일때
    elif (int(m) == 2):
        # day가 1~28이 아니라면 -1 출력 후 다음 case로
        if (not(1 <= int(d) <= 28)):
            print("#{} -1".format(test_case))
            continue
    # 4, 6, 9, 11월일때
    else:
         # day가 1~30이 아니라면 -1 출력 후 다음 case로
        if (not(1 <= int(d) <= 30)):
            print("#{} -1".format(test_case))
            continue

    print("#{} {}/{}/{}".format(test_case, y, m, d))