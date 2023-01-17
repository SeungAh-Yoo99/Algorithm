def recursion(s, l, r):
    global n
    n += 1
    if (l >= r):
        print(1, end=' ')
    elif s[l] != s[r]:
        print(0, end=' ')
    else:
        recursion(s, l + 1, r - 1)

def isPalindrome(s):
    recursion(s, 0, len(s) - 1)


t = int(input())

for _ in range(t):
    s = input()
    n = 0

    isPalindrome(s)
    print(n)