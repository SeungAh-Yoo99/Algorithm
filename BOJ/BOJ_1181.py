# 문제 핵심
# 1. 중복된 단어는 한 번만 출력
# 2. 문자열 길이로 오름차순 정렬
# 3. 문자열 길이가 같을 때는 사전 순으로 정렬

N = int(input())
str = []

# 단어들 입력
for i in range(N):
    str.append(input())
    
# set의 중복이 없다는 특징을 이용해서 단어들의 중복 제거
set_str = list(set(str))

# (단어 길이, 단어) 형태로 새로운 리스트에 저장.
# [(2, ab), (3, abc)] 형식으로
len_info_str = []
for i in set_str:
    len_info_str.append((len(i), i))
    
# 이를 sorted 함수로 정렬하면
# 우선 len을 기준으로 정렬하고,
# 다음으로 사전 순으로 정렬된다.
sorted_str = sorted(len_info_str)

# 현재 sorted_str은
# [(2, ab), (3, abc)]와 같이 정렬되어 있으므로
# 뒤의 단어만 따로 저장해준다.
result = []
for lgt, word in sorted_str:
    result.append(word)

# 출력
for word in result:    
    print(word)