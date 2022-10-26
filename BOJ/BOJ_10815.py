def binary_search(array, target, start, end):
    if start > end:
        return None
    
    mid = (start + end) // 2
    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    else:
        return binary_search(array, target, mid + 1, end)


n = int(input())
arr1 = sorted(list(map(int, input().split())))
# arr1 = set(map(int, input().split()))
m = int(input())
arr2 = list(map(int, input().split()))

for num in arr2:
    result = binary_search(arr1, num, 0, n - 1)

    if result == None:
        print(0, end=' ')
    else:
        print(1, end=' ')

# for num in arr2:
#     if num in arr1:
#         print(1, end=' ')
#     else:
#         print(0, end=' ')