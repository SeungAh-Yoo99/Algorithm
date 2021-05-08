n, m = input().split()
n = int(n)
m = int(m)
c = input().split()

for i in range(0, n):
    c[i] = int(c[i])

max = 0
for i in range(0, n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            sum = c[i] + c[j] + c[k]
            if ((max < sum) & (sum <= m)):
                max = sum

print(max)

"""
처음에 크기가 3인 max_list 리스트를 만들고 입력 받은 수 중 3개를 max_list에 넣는다.
입력 받은 수를 하나씩 max_list의 가장 작은 수 min과 비교해서, min보다는 크지만 min 대신에 max_list에 들어와도 m을 넘지 않으면 조건에 성립한다고 생각했다.
-> min 대신에 들어오면 m보다 커지지만 mid나 max 대신에 들어오면 m 보다는 작지만 이전의 max_list의 sum보다는 커질 수 있다.

그럼 min, mid, max 차례로 검사를 하면 위의 문제를 해결 할 수 있다고 생각했다.
-> 하지만 min+max < c[i]+c[j] 인 경우가 생긴다.

c를 정렬한 후, 가장 큰 수 3개부터 차례로 내려가며 max_list가 m보다 작아질 때까지 내려가면 최대의 max_list를 구할 수 있다고 생각했다.
-> 당연히 안된다. 2개의 작은 수의 합과 1개의 큰 수 값의 합이면 더 큰 max 값을 찾을 수 있다.

--->
해석을 봤다. 단순한 순열 조합 문제였다.
단순히 순열 조합을 하기엔 경우의 수가 너무 많을 거 같아 시간 제한에 걸릴 거라 생각했다.
다른 복잡하면서 신박한 알고리즘이 있을 줄 알았는데...
너무 복잡하게 생각하면 안될 것 같다.
"""