import sys

# 두개의 리스트를 입력 받는다.
# left와 right 리스트는 각자 정렬된 형태이다.
# 두 리스트를 합치며, 정렬된 하나의 리스트로 만들어 반환한다.
def merge(left, right):
    merge_arr = []
    i = j = 0
    
    # left, right 앞에서 부터 비교해서 작은 것을 append 해줌
    # left나 right 둘 중 하나의 리스트를 모두 append할 때까지
    while (i < len(left)) and (j < len(right)):
        if left[i] < right[j]:
            merge_arr.append(left[i])
            i += 1
        else:
            merge_arr.append(right[j])
            j += 1
        # 남은 리스트의 남은 원소를 마저 추가 해줌.
    merge_arr.extend(left[i:])
    merge_arr.extend(right[j:])
    return merge_arr
        
# 각 len이 1이 될 때까지 리스트를 반으로 쪼개준다.
# len이 1인 상태의 리스트는 정렬됐다고 할 수 있다.
# 이 정렬된 상태의 리스트 2개를 merge 함수를 통해 하나의 정렬된 리스트로 만들어준다.
# 재귀를 통해 다시 n 길이의 하나의 리스트가 될 때까지 수행해준다.
def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    leftArr = arr[:mid]
    rightArr = arr[mid:]
    leftArr = merge_sort(leftArr)
    rightArr = merge_sort(rightArr)
    return merge(leftArr, rightArr)

n = int(input())
num = [int(sys.stdin.readline()) for _ in range(n)]
#sorted_num = sorted(num)
sorted_num = merge_sort(num)

for i in sorted_num:
    print(i)