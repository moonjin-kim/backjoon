import sys
input = sys.stdin.readline

sys.setrecursionlimit(10**6)

M, N = map(int, input().split())

route = []
MAX = 500
dx = [0,0,1,-1]
dy = [1,-1,0,0]

dp = [[-1] * N for _ in range(M)]

def short_route(x,y):
  if x == N-1 and y == M-1:
    return 1
  if dp[y][x] != -1:
    return dp[y][x]
  dp[y][x] = 0
  for i in range(4):
    new_x = x + dx[i]
    new_y = y + dy[i]
    if 0 <= new_x < N and 0 <= new_y < M:
      if route[y][x] > route[new_y][new_x]:
        dp[y][x] += short_route(new_x, new_y)
  return dp[y][x]


for _ in range(M):
  a = list(map(int,input().split()))
  route.append(a)

print(short_route(0,0))
