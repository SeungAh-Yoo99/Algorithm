s = input()
ans = set()

for i in range(len(s)):
    for j in range(0, len(s) - i):
        ans.add(s[j:j + i + 1])

print(len(ans))