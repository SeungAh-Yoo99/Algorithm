T = int(input())
 
for test_case in range(1, T + 1):
    P, Q, R, S, W = map(int, input().split())
 
    companyA = W * P
 
    if (W > R):
        companyB = Q + (W - R) * S
    else:
        companyB = Q
 
    print("#{} {}".format(test_case, min(companyA, companyB)))