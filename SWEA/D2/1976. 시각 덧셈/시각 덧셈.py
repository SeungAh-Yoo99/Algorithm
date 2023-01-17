T = int(input())
 
for test_case in range(1, T + 1):
    h1, m1, h2, m2 = map(int, input().split())
 
    m = (m1 + m2) % 60
    h = ((h1 + h2 + ((m1 + m2) // 60) - 1) % 12) + 1
 
    print("#{} {} {}".format(test_case, h, m))