n, m = map(int, input().split())

A = set(map(int, input().split()))
B = set(map(int, input().split()))

a = A - B
b = B - A
print(len(a) + len(b))