n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))

sorted_a = sorted(a)

for num in b:
    start = 0
    end = len(a) - 1
    while(start < end):
        mid = (start + end) // 2
        if sorted_a[mid] < num:
            start = mid + 1
        elif sorted_a[mid] == num:
            end = mid
            break
        else:
            end = mid - 1
    if sorted_a[end] == num:
        print('1')
    else:
        print('0')