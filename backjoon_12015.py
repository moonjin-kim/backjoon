import sys

N = int(sys.stdin.readline().strip())

dp = [0] * (N+1)
scores = [0] * (N+1)
for i in range(1,N+1):
    scores[i] = int(input())

if N==1:
    dp[1] = scores[1]
elif N==2:
    dp[2] = scores[1]+scores[2]
else:
    dp[1] = scores[1]
    dp[2] = scores[1] + scores[2]
    for i in range(3,N+1):
        dp[i] = max(dp[i-2]+scores[i],dp[i-3] + scores[i-1]+ scores[i])

print(dp[-1])