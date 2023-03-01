import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
visited = []
house = []
result = []
max_count = 0
dx = [1,-1,0,0]
dy = [0,0,1,-1]

for _ in range(N):
    house.append(list(map(int, sys.stdin.readline().strip())))
    visited.append([0 for _ in range(N)])

stack = deque()
for i in range(N):
    for j in range(N):
        count = 0
        if house[i][j] == 1 and visited[i][j] == 0:
            stack.append([i,j])
            max_count += 1
            visited[i][j] = max_count
            result.append(1)
        while stack:
            point = stack.popleft()
            x = point[0]
            y = point[1]
            for k in range(4):
                if 0 <= x+dx[k] and x+dx[k] < N and 0 <= y+dy[k] and y+dy[k] < N:
                    if house[x+dx[k]][y+dy[k]] == 1 and visited[x+dx[k]][y+dy[k]] == 0:
                        stack.append([x+dx[k],y+dy[k]])
                        visited[x+dx[k]][y+dy[k]] = max_count
                        result[max_count-1] += 1


print(max_count)
result.sort()
for i in result:
    print(i)