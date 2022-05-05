# bubble sort 수행.
# 중간까지 했을 때 sort 종료하면, sort를 다 진행하지 않아도 중간값을 구할 수 있다.


N = int(input())

lst = list(map(int, input().split()))

for i in range(int(N / 2) + 1):
    for j in range(1, N - i):
        if (lst[j - 1] > lst[j]):
            tmp = lst[j - 1]
            lst[j - 1] = lst[j]
            lst[j] = tmp

# lst.sort()

print(lst[int(N / 2)])