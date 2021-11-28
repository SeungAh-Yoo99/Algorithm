# 뉴욕은 모든 쓰레기에 대해서 5씩 지불해야 한다.
# 6개 종류의 쓰레기에 대한 갯수를 입력 받을 때,
# 지불해야 하는 총 금액을 출력하라.

num = list(map(int, input().split()))

total = 0
for i in range(len(num)):
    total += num[i] * 5
    
print(total)