n, m = map(int, input().split())

book = {}
for i in range(1, n + 1):
    name = input()
    book[name] = i
    book[str(i)] = name

for _ in range(m):
    print(book[input()])