arr = []

while(True):
    try:
        n, s = map(int, input().split())
        arr.append(s // (n + 1))
    except:
        for i in arr:
            print(i)
        break