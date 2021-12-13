A, B = map(int, input().split())
C = int(input())

A = (A + ((B + C) // 60)) % 24
B = (B + C) % 60

print(A, B)