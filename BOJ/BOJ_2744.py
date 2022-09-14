string = input()
# result = ""

# for s in string:
#     #대문자라면
#     if ord(s) >= ord('A') and ord(s) <= ord('Z'):
#         result += chr(ord(s) - ord('A') + ord('a'))
#     #소문자라면
#     else:
#         result += chr(ord(s) - ord('a') + ord('A'))

# print(result)

# print(string.swapcase())

result = []

for s in string:
    if s.isupper():
        result.append(s.lower())
    else:
        result.append(s.upper())

print(''.join(result))