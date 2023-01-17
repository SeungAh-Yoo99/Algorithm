from collections import deque
 
for _ in range(1, 11):
    # 암호 생성에 사용할 큐
    q = deque()
 
    # 테스트 케이스 번호 입력
    test_case = int(input())
    # n개의 수 입력
    arr = list(map(int, input().split()))
 
    # n개의 수 큐에 넣기
    q.extend(arr)
 
    # 0보다 작거나 같은 수가 나올 때까지 사이클 반복
    a = True
    while(a):
        for i in range(1, 6):
            # 큐의 왼쪽 원소를 빼서
            n = q.popleft()
            # i만큼 감소 후
            n -= i
            # 0보다 크다면
            if n > 0:
                # 큐의 맨 뒤에 다시 넣어준다.
                q.append(n)
            # 0보다 작거나 같다면
            else:
                # 큐에 0을 넣어주고
                q.append(0)
                # while문을 끝내기 위해 a를 False로 바꿔주고
                a = False
                # for문을 나온다.
                break
 
    # 큐를 리스트로 바꿔준다.
    result = list(q)
 
    print("#{}".format(test_case), end=' ')
    print(*result)
