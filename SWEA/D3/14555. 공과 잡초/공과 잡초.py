# 테스트 케이스의 수 t
t = int(input())
 
for test_case in range(1, t + 1):
	s = input()
 
	result = 0
	i = 0
	while(i < len(s)):
		if s[i] == '(':
			if s[i + 1] == ')':
				result += 1
				i += 1
			else:
				result += 1
		elif s[i] == ')':
			result += 1
		i += 1
 
	print("#{} {}".format(test_case, result))
