def merge_sort(A, p, r):
    if p < r:
        q = (p + r) // 2 # q는 p, r의 중간 지점
        merge_sort(A, p, q) # 전반부 정렬
        merge_sort(A, q + 1, r) # 후반부 정렬
        merge(A, p, q, r) # 병합

# A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
# A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
def merge(A, p, q, r):
    i, j, t = p, q + 1, 1
    global k, ans, num
    tmp = []
    while(i <= q and j <= r):
        if A[i] <= A[j]:
            tmp.append(A[i])
            i += 1
        else:
            tmp.append(A[j])
            j += 1

    while(i <= q): # 왼쪽 배열 부분이 남은 경우
        tmp.append(A[i])
        i += 1
    while(j <= r): # 오른쪽 배열 부분이 남은 경우
        tmp.append(A[j])
        j += 1

    i, t = p, 0
    while (i <= r): # 결과를 A[p..r]에 저장
        A[i] = tmp[t]
        num += 1
        if num == k: # k번째 저장하는 것이라면 ans에 현재 저장하는 수를 저장.
            ans = A[i]
        i += 1
        t += 1


n, k = map(int, input().split())
A = list(map(int, input().split()))
ans, num = 0, 0
merge_sort(A, 0, n - 1)
if ans == 0: # 저장 횟수가 k보다 작을 때
    print(-1)
else:
    print(ans)