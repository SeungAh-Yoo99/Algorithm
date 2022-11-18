# 테스트 케이스의 수 t
t = int(input())

for test_case in range(1, t + 1):
    # 숫자판의 정보 board, 교환 횟수 n
    board, n = input().split()
    n = int(n)
    # 중복을 제거한 경우의 수를 담아주기 위한 set
    now = set([board])
    nxt = set()
    
    # 교횐 횟수만큼 반복
    for _ in range(n):
        # now가 빌 때까지
        while now:
            s = now.pop()
            # 리스트로 변환
            s = list(s)
            # 가능한 모든 교환 경우의 수를 nxt에 담는다
            # set 자료구조의 특성상 중복은 알아서 걸러진다.
            for i in range(len(board) - 1):
                for j in range(i + 1, len(board)):
                    s[i], s[j] = s[j], s[i]
                    nxt.add(''.join(s))
                    # 원상복귀
                    s[i], s[j] = s[j], s[i]

        # 모든 경우의 수를 nxt에 담았으니
        # 다음 교환을 위해 now에 nxt를 nxt에 빈 set를 할당
        now, nxt = nxt, now

    answer = max(map(int, now))
    print("#{} {}".format(test_case, answer))
