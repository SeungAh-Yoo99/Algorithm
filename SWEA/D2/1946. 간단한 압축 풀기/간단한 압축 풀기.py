T = int(input())
 
for test_case in range(1, T + 1):
    N = int(input())
 
    text = ""
    for _ in range(N):
        c, k = input().split()
        text += c * int(k)
 
    print("#{}".format(test_case))
    for i in range(0, len(text), 10):
        print(text[i:i+10])