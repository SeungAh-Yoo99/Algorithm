for _ in range(3):
    h1, m1, s1, h2, m2, s2 = map(int, input().split())

    if s2 < s1:
        m2 -= 1
        s = s2 + 60 - s1
    else:
        s = s2 - s1

    if m2 < m1:
        h2 -= 1
        m = m2 + 60 - m1
    else:
        m = m2 - m1

    h = h2 - h1

    print(h, m, s)