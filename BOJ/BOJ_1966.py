test_case = int(input())

for i in range(test_case):
    n, m = map(int, input().split())
    queue = list(map(int, input().split()))
    cnt = 0 # m이 queue를 몇 번째에 빠져났는지 저장
    
    while(m != -1): # m이 -1이라면 큐를 빠져나온 것.
        if queue[0] == max(queue): # 큐의 맨 앞이 제일 크면
            del queue[0] # 삭제해주고
            m -= 1 # m이 한 칸 앞을 가리키게 한다.
            cnt += 1
        else: # 맨 앞이 제일 크지 않으면
            queue.append(queue[0]) # 뒤에 추가해주고
            del queue[0] # 맨 앞은 지워준다.
            
            if m == 0: # m이 0이었다면
                m = len(queue) - 1 # 해당 자리에 있던 수가 뒤로 갔으니 m도 맨 뒤를 가리키게 한다.
            else: # m이 0이 아니었다면
                m -= 1 # 한 칸 앞을 가리키게 한다.
                
    print(cnt)