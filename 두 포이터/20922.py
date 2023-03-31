import sys

N, K = map(int,input().split())

num = list(map(int,input().split()))

end = 0
dic = [0 for _ in range(100001)]
max_len = 0
print(dic[5])
for start in range(N):
    while end < N:
        if dic[num[end]] < K:
            dic[num[end]] += 1
            end += 1
        else:
            break
    length = end - start
    max_len = max(max_len,length)
    dic[num[start]] = dic[num[start]] - 1

print(max_len)