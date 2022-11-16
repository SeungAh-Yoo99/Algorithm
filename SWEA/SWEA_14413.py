# 테스트 케이스의 수 t 입력
t = int(input())

for test_case in range(1, t + 1):
	# 행의 수 n, 열의 수 m 입력
	n, m = map(int, input().split())
	# 2차원 배열의 동, 남 이동
	dx = [0, 1]
	dy = [1, 0]

	# 문자열 입력
	array = []
	for i in range(n):
		array.append(list(input()))

	result = ''
	for i in range(n):
		for j in range(m):
			# 동쪽, 남쪽 중 하나라도 같은 문자라면 답은 imposiible
			# 모두 다른 문자라면 continue
			# ?라면 #일 경우 .을, .일 경우 #를 찍어준다.
			for k in range(2):
				# 인덱스 범위 체크
				if i + dx[k] < n and j + dy[k] < m:
					if array[i + dx[k]][j + dy[k]] == '?':
						if array[i][j] == '#':
							array[i + dx[k]][j + dy[k]] = '.'
						elif array[i][j] == '.':
							array[i + dx[k]][j + dy[k]] = '#'
					elif array[i][j] == array[i + dx[k]][j + dy[k]]:
						result = "impossible"
						break
			# 답이 이미 impossible이면 반복문 빠져 나오게 하기
			if result == "impossible":
				break
		# 답이 이미 impossible이면 반복문 빠져 나오게 하기
		if result == "impossible":
			break

	if result != 'impossible':
		result = 'possible'

	print("#{} {}".format(test_case, result))