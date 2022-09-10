T = int(input())

for test_case in range(1, T + 1):
    input() #테스트 케이스의 번호 입력인데, 저장할 필요가 없어보인다.
    score = list(map(int, input().split()))
    cnt = [0] * 101

    for i in range(len(score)):
        cnt[score[i]] += 1

    #최빈수가 나온 횟수
    max_cnt = max(cnt)

    #가장 큰 최빈수를 구함
    for i in range(len(cnt) - 1, -1, -1):
        if cnt[i] == max_cnt:
            max_cnt_idx = i
            break

    print("#{} {}".format(test_case, max_cnt_idx))