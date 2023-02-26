import sys
input = sys.stdin.readline

dp = [[0] * 15001 for _ in range(31)]
r = []
n = int(input())
weight = list(map(int,input().split()))

def DP(i,w):
  if n < i or dp[i][w]:
    return ;
  dp[i][w] = 1
  DP(i +1,w)
  DP(i +1,w+weight[i-1])
  DP(i + 1,abs(w-weight[i-1]))

m = int(input())
weight_check = list(map(int,input().split()))

DP(0,0)
for i in weight_check:
    if i > 30*500:
        r.append("N")
        continue
    if dp[n][i] == 1:
        r.append("Y")
    else:
        r.append("N")
print(*r)
