import sys
from collections import deque
input = sys.stdin.readline

N, M, R = map(int, input().split())

visited = [0 for i in range(N+1)]
graph = [[] for _ in range(N+1)]

for i in range(M):
    start, end = list(map(int,input().split()))
    graph[start].append(end)
    graph[end].append(start)

for i in range(N):
    graph[i].sort(reverse=True)


stack = deque()
stack.append(R)

visited[R] = 1
count = 2

while stack:
    index = stack.popleft()
    for k in graph[index]:
        if visited[k] == 0:
            visited[k] = count
            count += 1
            stack.append(k)

for i in range(1,N+1):
    print(visited[i])
