# queue의 index가 홀수(1, 3, 5 ...)면 뒤로 보내고
# 짝수(0, 2, 4 ...)면 삭제함

n = int(input())

queue = [i+1 for i in range(n)]

while(len(queue) > 1):
    # 뒤로 보내야 할 수들이 꼭 홀수번에 오도록 만들어준다.
    if len(queue) % 2 == 0:
        queue = queue[1::2]
    else:
        q = [queue[-1]]
        q.extend(queue[1::2])
        queue = q
        
print(queue[0])