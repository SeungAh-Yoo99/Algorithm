A, B, C = map(int, input().split())
D = int(input())

A = (A + (B + ((C + D) // 60)) // 60) % 24
B = (B + ((C + D) // 60)) % 60
C = (C + D) % 60

print(A, B, C)