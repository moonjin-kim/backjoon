import sys
input = sys.stdin.readline

N, M = map(int,input().split())
memorys = list(map(int,input().split()))
cost = list(map(int,input().split()))
dp = [[0 for _ in range(sum(cost)+1)] for _ in range(N+1)]
result = sum(cost)

for i in range(1,N+1):
  for j in range(len(dp[0])):
    if j < cost[i-1]:
      dp[i][j] = dp[i-1][j]
    else:
      dp[i][j] = max(dp[i-1][j],dp[i-1][j-cost[i-1]]+memorys[i-1])
    if dp[i][j] >= M and result > j:
      result = j

print(result)