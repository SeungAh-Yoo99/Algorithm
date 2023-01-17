base64Encoding = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
                'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
                'z', '0' ,'1', '2', '3', '4', '5', '6', '7', '8',
                '9', '+', '/']
 
T = int(input())
 
for test_case in range(1, T + 1):
    encoding_str = input()
    bin_str = ""
 
    #입력받은 문자열을 문자 하나씩 해당하는 값으로 바꿔준 후
    #6자리 2진수로 변환 후 bin_str 문자열에 추가
    for i in range(len(encoding_str)):
        bin_str += format(base64Encoding.index(encoding_str[i]), 'b').zfill(6)
 
    decoding_str = ""
 
    #bin_str에 저장되어 있는 2진수 문자열을 8자리씩 끊어 다시 10진수로 변환
    #변환된 10진수 수를 아스키 코드에 해당하는 문자로 변환 후 decoding_str 문자열에 추가
    for i in range(0, len(bin_str), 8):
       decoding_str += chr(int(bin_str[i:i+8], 2))
 
    print("#{} {}".format(test_case, decoding_str))