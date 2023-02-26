import sys

N, M = map(int,input().split())
nums = list(map(int,input().split()))
remain_count = [0 for _ in range(M)]
remain_count[0] = 1

count = 0
a= 0
for i in range(1,N):
        a += nums[i-1]
        a %= M
        remain_count[a] += 1

answer = 0
for i in range(M):
    a = remain_count[i]
    answer += a*(a-1)//2
print(answer)