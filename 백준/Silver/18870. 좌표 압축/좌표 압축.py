n = int(input())
x = list(map(int, input().split()))

# x를 정렬 & 중복 제거
arr = sorted(list(set(x.copy())))
# 딕셔너리에 인덱스와 값을 넣어 빨리 찾을 수 있게 함
dic = {}
for i in range(len(arr)):
    dic[arr[i]] = i


for i in range(n):
    print(dic[x[i]], end=' ')